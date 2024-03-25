package com.example.Services2_Oder;

import com.example.Services2_Oder.models.Order;
import com.example.Services2_Oder.repositories.OrderRepository;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.LocalDateTime;

@SpringBootApplication
@EnableCaching
public class Services2OderApplication {
	private final OrderRepository orderRepository;
	private final Faker faker = new Faker();

	public Services2OderApplication(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Services2OderApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			for (int i = 1; i <= 10; i++) {
				Order order = createFakeOrder();
				orderRepository.save(order);
			}
		};
	}

	private Order createFakeOrder() {
		Order order = new Order();
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime pastDate = now.minus(Duration.ofDays(10));
		order.setOrderDate(pastDate);
		order.setStatus(faker.lorem().word());
		order.setShippingAddress(faker.address().fullAddress());
		return order;
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
