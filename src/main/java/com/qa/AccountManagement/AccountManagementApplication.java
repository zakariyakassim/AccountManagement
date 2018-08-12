package com.qa.AccountManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.qa.AccountManagement.repository")
@SpringBootApplication
public class AccountManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountManagementApplication.class, args);
	}
}
