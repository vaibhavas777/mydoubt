package com.vas.mydoubt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MyDoubtApplication {


	public static void main(String[] args) {
		SpringApplication.run(MyDoubtApplication.class, args);
	}

}
