package com.example.accessingdatajpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity  // This annotation marks the class as a JPA entity (a database table representation).
public class Customer {

	@Id  // This annotation marks the 'id' attribute as the primary key of the table.
	@GeneratedValue(strategy=GenerationType.AUTO)  // Indicates that the 'id' value should be generated automatically.
	private Long id;
	private String firstName;
	private String lastName;

	protected Customer() {}  // Default constructor required by JPA for creating a new instance.

	// Constructor to initialize a new Customer object with first and last names.
	public Customer(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// Override the default toString method to provide a custom representation of the Customer object.
	@Override
	public String toString() {
		return String.format(
				"Customer[id=%d, firstName='%s', lastName='%s']",
				id, firstName, lastName);
	}

	// Getter method to retrieve the 'id' attribute.
	public Long getId() {
		return id;
	}

	// Getter method to retrieve the 'firstName' attribute.
	public String getFirstName() {
		return firstName;
	}

	// Getter method to retrieve the 'lastName' attribute.
	public String getLastName() {
		return lastName;
	}
}

/*
Reminders:
- Always annotate the entity class with @Entity.
- Ensure there's a default constructor, even if it's empty.
- Use the @Id annotation for the primary key attribute.
- Getter methods provide a way to access the attributes of the entity.
*/
