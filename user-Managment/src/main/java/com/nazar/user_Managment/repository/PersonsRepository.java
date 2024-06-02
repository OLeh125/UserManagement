package com.nazar.user_Managment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nazar.user_Managment.entity.Person;

//TODO always in class naming use singular nouns like PersonRepository
//TODO add two more implementation using JDBC and HIBERNATE
public interface PersonsRepository extends JpaRepository<Person , Long>{//імплементуємо багато логіки

}
