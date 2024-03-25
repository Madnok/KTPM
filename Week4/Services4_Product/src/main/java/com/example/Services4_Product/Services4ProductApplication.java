package com.example.Services4_Product;

import com.example.Services4_Product.models.Product;
import com.example.Services4_Product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Services4ProductApplication {
	@Autowired
	private final ProductRepository productRepository;

	public Services4ProductApplication(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Services4ProductApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				for (int i = 1; i <= 10; i++) {
					productRepository.save(new Product(i, "Product" + i, 123));
				}
			}
		};

	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}