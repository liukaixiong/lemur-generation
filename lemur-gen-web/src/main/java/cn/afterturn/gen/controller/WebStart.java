package cn.afterturn.gen.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
@ComponentScan("cn.afterturn.gen")
@MapperScan("cn.afterturn.gen.repository")
public class WebStart {

    public static void main(String[] args) {
        SpringApplication.run(WebStart.class, args);
    }
}
