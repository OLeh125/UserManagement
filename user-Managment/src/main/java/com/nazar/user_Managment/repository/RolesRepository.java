package com.nazar.user_Managment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nazar.user_Managment.entity.Role;

public interface RolesRepository extends JpaRepository<Role , Long>{
	
}
