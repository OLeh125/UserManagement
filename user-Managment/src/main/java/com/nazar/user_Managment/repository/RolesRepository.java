package com.nazar.user_Managment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nazar.user_Managment.entity.Role;

//TODO always in class naming use singular nouns like PersonRepository
//TODO add two more implementation using JDBC and HIBERNATE
public interface RolesRepository extends JpaRepository<Role , Long>{

}
