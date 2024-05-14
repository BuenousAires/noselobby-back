package com.haomu.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.haomu.app"})
@MapperScan("com.haomu.**.mapper")
@RestController
public class NoselobbyAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoselobbyAppApplication.class, args);
    }

}
