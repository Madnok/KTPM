package com.example.service1_1_User;

import com.example.service1_1_User.models.User;
import com.example.service1_1_User.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Service11UserApplication {
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Service11UserApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				for (int i=1; i<=10; i++){
					userRepository.save(new User(i, "User" + i));
				}
			}
		};
	}
}
