package com.example.demo;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LoadDatabase.class);
	@Bean
	CommandLineRunner initDatabase(EmployeeRepository repository, OrderRepository orderRepository) {
		return args -> {
			log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "burglar")));
			log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));
			log.info("Preloading " + orderRepository.save(new Order("MacBook Pro", Order.Status.COMPLETED)));
			log.info("Preloading " + orderRepository.save(new Order("iPhone", Order.Status.IN_PROGRESS)));
		};
		
		orderRepository.findAll().forEach(order -> {
			log.info("Preloaded " + order);
		});
	}
}