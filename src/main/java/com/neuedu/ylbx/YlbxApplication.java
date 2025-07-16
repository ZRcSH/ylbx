package com.neuedu.ylbx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan(basePackages="com.neuedu.ylbx.mapper")
public class YlbxApplication {

    public static void main(String[] args) {
        SpringApplication.run(YlbxApplication.class, args);
    }

}
