package com.design.petmanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.design.petmanagement.mapper")
@ComponentScan(value="com.design")
public class PetmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetmanagementApplication.class, args);
	}

}
