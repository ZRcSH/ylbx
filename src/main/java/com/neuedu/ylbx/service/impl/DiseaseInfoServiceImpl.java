package com.neuedu.ylbx.service.impl;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.ylbx.dto.DiseaseInfoPageDTO;
import com.neuedu.ylbx.mapper.DiseaseInfoMapper;
import com.neuedu.ylbx.pojo.DiagnosisTreatment;
import com.neuedu.ylbx.pojo.DiseaseInfo;
import com.neuedu.ylbx.service.DiseaseInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class DiseaseInfoServiceImpl extends ServiceImpl<DiseaseInfoMapper, DiseaseInfo>
        implements DiseaseInfoService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Page<DiseaseInfo> queryPage(DiseaseInfoPageDTO dto) {
        // 1. 构建缓存键
        String cacheKey;
        if(dto.getDiseaseName()==null) {
            cacheKey = "DiseaseInfo:" + dto.getPageNum();
        }else {
            cacheKey = "DiseaseInfo:" +dto.getDiseaseName()+ dto.getPageNum();
        }


        // 2. 尝试从Redis获取缓存
        Page<DiseaseInfo> cachedPage = getFromCache(cacheKey);
        if (cachedPage != null) {
            return cachedPage;
        }

        // 3. 缓存未命中：查询数据库
        Page<DiseaseInfo> page = new Page<>(dto.getPageNum(), dto.getPageSize());
        LambdaQueryWrapper<DiseaseInfo> wrapper = new LambdaQueryWrapper<>();

        if (StringUtils.isNotBlank(dto.getDiseaseName())) {
            wrapper.like(DiseaseInfo::getDiseaseName, dto.getDiseaseName());
        }

        // 执行实际查询
        Page<DiseaseInfo> resultPage = baseMapper.selectPage(page, wrapper);

        // 4. 缓存查询结果
        cacheResult(cacheKey, resultPage);

        return resultPage;
    }



    // 从缓存获取数据
    private Page<DiseaseInfo> getFromCache(String key) {
        String json = stringRedisTemplate.opsForValue().get(key);
        if (json == null) {
            return null;
        }
        log.info("redis查询结果{}",json);
        Page<DiseaseInfo> page = JSONUtil.toBean(json, new TypeReference<Page<DiseaseInfo>>() {}, false);
        return page;
    }

    // 缓存查询结果
    private void cacheResult(String key, Page<DiseaseInfo> result) {
        try {
            // 只缓存有数据的查询结果
            if (result != null && !result.getRecords().isEmpty()) {
                // 设置30分钟过期时间
                stringRedisTemplate.opsForValue().set(
                        key,
                        JSONUtil.toJsonStr(result),
                        30, TimeUnit.MINUTES
                );
            }
        } catch (Exception e) {
            log.error("Redis缓存写入异常", e);
        }
    }

    // === 数据更新时需要调用此方法使缓存失效 ===
    public void deleteCache() {
        Set<String> keys = stringRedisTemplate.keys("DiseaseInfo:*");

        // 如果匹配的 key 不为空，则删除它们
        if (keys != null && !keys.isEmpty()) {
            stringRedisTemplate.delete(keys);
        }
    }
}
