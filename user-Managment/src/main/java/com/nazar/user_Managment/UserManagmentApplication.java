package com.nazar.user_Managment;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//TODO fix naming
public class UserManagmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserManagmentApplication.class, args);
//		TODO move to properties file
		Flyway flyway = Flyway.configure().dataSource("jdbc:postgresql://localhost:5432/userManegment", "postgres", "postgres").load();
//        TODO remove
		flyway.repair();
	}
}
