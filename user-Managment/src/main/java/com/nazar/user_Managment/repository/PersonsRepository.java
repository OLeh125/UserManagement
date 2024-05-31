package com.nazar.user_Managment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nazar.user_Managment.entity.Person;

public interface PersonsRepository extends JpaRepository<Person , Long>{//імплементуємо багато логіки
	
}
