package com.neuedu.ylbx.service.impl;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neuedu.ylbx.dto.DrugInfoPageDTO;
import com.neuedu.ylbx.mapper.DrugInfoMapper;
import com.neuedu.ylbx.pojo.DiseaseInfo;
import com.neuedu.ylbx.pojo.DrugInfo;
import com.neuedu.ylbx.service.DrugInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class DrugInfoServiceImpl extends ServiceImpl<DrugInfoMapper, DrugInfo> implements DrugInfoService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public IPage<DrugInfo> pageQuery(DrugInfoPageDTO dto) {
        // 1. 构建缓存键
        String cacheKey;
        if(dto.getChinaName()==null) {
            cacheKey = "DrugInfo:" + dto.getPageNum();
        }else {
            cacheKey = "DrugInfo:" +dto.getChinaName()+ dto.getPageNum();
        }


        // 2. 尝试从Redis获取缓存
        Page<DrugInfo> cachedPage = getFromCache(cacheKey);
        if (cachedPage != null) {
            return cachedPage;
        }

        // 3. 缓存未命中：查询数据库
        Page<DrugInfo> page = new Page<>(dto.getPageNum(), dto.getPageSize());
        LambdaQueryWrapper<DrugInfo> wrapper = new LambdaQueryWrapper<>();

        if (StringUtils.isNotBlank(dto.getChinaName())) {
            wrapper.like(DrugInfo::getChinaName, dto.getChinaName());
        }

        // 执行实际查询
        Page<DrugInfo> resultPage = baseMapper.selectPage(page, wrapper);

        // 4. 缓存查询结果
        cacheResult(cacheKey, resultPage);

        return resultPage;
    }



    // 从缓存获取数据
    private Page<DrugInfo> getFromCache(String key) {
        String json = stringRedisTemplate.opsForValue().get(key);
        if (json == null) {
            return null;
        }
        log.info("redis查询结果{}",json);
        Page<DrugInfo> page = JSONUtil.toBean(json, new TypeReference<Page<DrugInfo>>() {}, false);
        return page;
    }

    // 缓存查询结果
    private void cacheResult(String key, Page<DrugInfo> result) {
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
        Set<String> keys = stringRedisTemplate.keys("DrugInfo:*");

        // 如果匹配的 key 不为空，则删除它们
        if (keys != null && !keys.isEmpty()) {
            stringRedisTemplate.delete(keys);
        }
    }
}
