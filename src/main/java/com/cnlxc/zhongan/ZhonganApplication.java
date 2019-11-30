package com.cnlxc.zhongan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cnlxc.zhongan.dao")
public class ZhonganApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZhonganApplication.class, args);
	}

}
