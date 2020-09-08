package com.example.source_manager_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EntityScan("com.example.source_manager_server.entity")
@EnableJpaRepositories("com.example.source_manager_server.repository")
public class SourceManagerServerApplication
{
	public static void main(String[] args) {
		SpringApplication.run(SourceManagerServerApplication.class, args);
	}

}
