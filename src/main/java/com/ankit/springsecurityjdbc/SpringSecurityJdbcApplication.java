package com.ankit.springsecurityjdbc;

import com.ankit.springsecurityjdbc.models.User;
import com.ankit.springsecurityjdbc.repositories.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserDetailsRepository.class)
public class SpringSecurityJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJdbcApplication.class, args);
	}

}
