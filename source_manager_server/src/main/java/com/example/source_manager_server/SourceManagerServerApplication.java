package com.example.source_manager_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class SourceManagerServerApplication
{
	public static void main(String[] args) {
		SpringApplication.run(SourceManagerServerApplication.class, args);
	}

}
