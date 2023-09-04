package com.example.accessingdatajpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// This interface provides methods to interact with the database for 'Customer' entities.
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	// Custom query method to fetch 'Customer' entities by their last name.
	List<Customer> findByLastName(String lastName);

	// Custom query method to fetch a 'Customer' entity by its ID.
	Customer findById(long id);
}

/*
Reminders:
- The repository interface should extend CrudRepository or another Spring Data JPA repository type.
- Custom query methods (like findByLastName) don't need manual implementation. Spring Data JPA provides it.
- Ensure the correct data type is used for the ID in CrudRepository (e.g., Long for 'Customer').
*/
