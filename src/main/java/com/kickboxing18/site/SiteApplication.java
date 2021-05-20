package com.kickboxing18.site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SiteApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(SiteApplication.class, args);
	}

}
