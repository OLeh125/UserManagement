package com.nazar.user_Managment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
@Entity //say it to do smth with hibernate
@Table(name = "persons")
public class Person {	
	public Person(Long id, String firstName, String lastName, String email, int age, Role role) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.age = age;
		this.role = role;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@Pattern(regexp = "^[a-zA-Z]{3,}$", message = "First name must contain only letters and have at least 3 characters")
	private String firstName;
	
	@Pattern(regexp = "^[a-zA-Z]{3,}$", message = "Last name must contain only letters and have at least 3 characters")
	@Column(nullable = false)
	private String lastName;
	
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email format")
	@Column(nullable = false)
	private String email;
	
	@Digits(integer = 2, fraction = 0, message = "Age must be a number")
	@Min(value = 5, message = "Age must be at least 5")
	@Column(nullable = false)
	private int age;
	
	@ManyToOne
	@JoinColumn(name = "role_id" , nullable = false)
	private Role role;

	public void addRole(Role role) {
		this.role = role; // Set the role for this person
	    role.getPersons().add(this); // Add this person to the set of persons in the role
	}	
}
	