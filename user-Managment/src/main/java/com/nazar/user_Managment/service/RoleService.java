package com.nazar.user_Managment.service;

import org.springframework.stereotype.Service;

import com.nazar.user_Managment.entity.Role;
import com.nazar.user_Managment.repository.PersonsRepository;

import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleService {
	private final PersonsRepository personsRepository;
	
	public RoleService(PersonsRepository personsRepository) {
		this.personsRepository = personsRepository;
	}
	
	@Transactional // щоб не порушити атомарність (операція виконується або не виконується)
	public void addRole(Long personId , Role role) {
		//add role by persons id
		var person = personsRepository.findById(personId)
				.orElseThrow();
		person.addRole(role);
	}
}