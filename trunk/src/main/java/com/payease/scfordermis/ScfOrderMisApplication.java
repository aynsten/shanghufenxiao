package com.payease.scfordermis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ljp on 2018/1/4.
 */
@EnableRedisHttpSession
@SpringBootApplication
@ComponentScan("com.payease.scfordermis")
public class ScfOrderMisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScfOrderMisApplication.class, args);
    }
}
