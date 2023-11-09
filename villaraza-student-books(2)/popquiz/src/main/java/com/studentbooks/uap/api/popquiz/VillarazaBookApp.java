package com.studentbooks.uap.api.popquiz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.studentbooks.uap.api.popquiz.repository")
public class VillarazaBookApp {

	public static void main(String[] args) {
		SpringApplication.run(VillarazaBookApp.class, args);
	}

}
