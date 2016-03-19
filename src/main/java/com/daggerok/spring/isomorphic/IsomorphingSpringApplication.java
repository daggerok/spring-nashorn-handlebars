package com.daggerok.spring.isomorphic;

import com.daggerok.spring.isomorphic.config.AppCfg;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(AppCfg.class)
@SpringBootApplication
public class IsomorphingSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(IsomorphingSpringApplication.class, args);
	}
}
