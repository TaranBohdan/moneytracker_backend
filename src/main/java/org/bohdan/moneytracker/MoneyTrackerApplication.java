package org.bohdan.moneytracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class MoneyTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoneyTrackerApplication.class, args);
	}

}
