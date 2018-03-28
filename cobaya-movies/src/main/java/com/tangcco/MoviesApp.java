package com.tangcco;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 影视启动类
 * 
 * @author jifeng
 *
 *         2018年3月20日
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = { "com.tangcco.cobaya.mapper" })
public class MoviesApp {

	public static void main(String[] args) {
		SpringApplication.run(MoviesApp.class, args);
	}

}
