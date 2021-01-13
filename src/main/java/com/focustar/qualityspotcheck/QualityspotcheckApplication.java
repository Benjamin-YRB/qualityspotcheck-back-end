package com.focustar.qualityspotcheck;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.focustar.qualityspotcheck.mapper")
public class QualityspotcheckApplication {

    public static void main(String[] args) {
        SpringApplication.run(QualityspotcheckApplication.class, args);
    }

}
