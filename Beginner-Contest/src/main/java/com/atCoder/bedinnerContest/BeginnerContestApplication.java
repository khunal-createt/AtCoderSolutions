package com.atCoder.bedinnerContest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BeginnerContestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeginnerContestApplication.class, args);
	}

}
