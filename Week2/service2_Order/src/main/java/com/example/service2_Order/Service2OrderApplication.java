package com.example.service2_Order;

import com.example.service2_Order.models.Order;
import com.example.service2_Order.repositories.OrderRepository;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.time.LocalDate;
import java.time.ZoneId;

@SpringBootApplication
public class Service2OrderApplication {
	private final OrderRepository orderRepository;
	private final Faker faker = new Faker();

	public Service2OrderApplication(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Service2OrderApplication.class, args);
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
		LocalDate pastDate = faker.date().birthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		Order order = new Order();
		order.setOrderDate(pastDate.atStartOfDay());
		order.setStatus(faker.lorem().word());
		order.setShippingAddress(faker.address().fullAddress());
		return order;
	}
}
