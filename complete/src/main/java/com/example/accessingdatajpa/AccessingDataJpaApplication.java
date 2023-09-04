package com.example.accessingdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

// Import necessary libraries and dependencies

@SpringBootApplication  // This annotation marks the class as a Spring Boot application.
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);


	// Main method - Entry point of the application
	public static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class, args);
	}

	// This method demonstrates CRUD operations using the CustomerRepository
	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			// Save a few customers to the database
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			// Fetch all customers and print them
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// Fetch a specific customer by ID and print it
			Customer customer = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// Fetch customers by last name and print them
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			for (Customer bauer : repository.findByLastName("Bauer")) {
				log.info(bauer.toString());
			}
			log.info("");
		};
	}
}

/*
Reminders:
- The @SpringBootApplication annotation is essential for initializing a Spring Boot application.
- The repository provides methods to interact with the database. No need to write SQL queries.
- Always ensure that entity classes (like Customer) have the necessary annotations like @Entity and @Id.
- Custom query methods (like findByLastName) in the repository don't need manual implementation. Spring Data JPA handles it.
*/
