package com.nazar.user_Managment.entity;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity //say it to do smth with hibernate
@Table(name = "roles")
public class Role {
	public enum RoleType{
		STUDENT,
		WORKER,
		RETIRED,
		PUPIL,
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;
	
	@Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RoleType role;
	
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
	private Set<Person> persons = new HashSet<>();
    
	
	public Role(Long roleId, RoleType role, Set<Person> persons) {
	     this.roleId = roleId;
	     this.role = role;
	     this.persons = persons;
	 }

	 public Long getRoleId() {
	     return roleId;
	 }

	 public void setRoleId(Long roleId) {
	     this.roleId = roleId;
	 }

	 public RoleType getRole() {
	     return role;
	 }

	 public void setRole(RoleType role) {
	     this.role = role;
	 }

	 public Set<Person> getPersons() {
	     return persons;
	 }

	 public void setPersons(Set<Person> persons) {
	     this.persons = persons;
	 }

	 public void addPerson(Person person) {
	     this.persons.add(person);
      person.setRole(this);
	 }
}
