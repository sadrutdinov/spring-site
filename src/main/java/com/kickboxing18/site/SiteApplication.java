package com.kickboxing18.site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@SpringBootApplication
public class SiteApplication implements WebMvcConfigurer {

	@Bean // параметры для jdbcTemplate
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/first_db");
		dataSource.setUsername("postgres");
		dataSource.setPassword("PandaFXThe1");


		return dataSource;
	}

	@Bean // от jdbcTemplate
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

	public static void main(String[] args) {
		SpringApplication.run(SiteApplication.class, args);
	}

}
