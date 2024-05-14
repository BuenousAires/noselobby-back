package com.haomu.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = {"com.haomu"})
@MapperScan("com.haomu.**.mapper")
@RestController
public class NoselobbySystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoselobbySystemApplication.class, args);
    }

}
