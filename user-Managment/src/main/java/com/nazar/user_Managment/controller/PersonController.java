package com.nazar.user_Managment.controller;

import com.nazar.user_Managment.entity.Person;
import com.nazar.user_Managment.repository.PersonsRepository;
import com.nazar.user_Managment.service.PersonService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController//обробляє http запити і поверта дані у json or xml
@RequestMapping("/persons")//path
//TODO lets rename it to PersonController
public class PersonController {

	//TODO not a good practice to call repository on controller level
	//TODO move to service level
	//TODO rename ALL Persons to User
	private final PersonsRepository personsRepository;

	private final PersonService personService;

	public PersonController(PersonsRepository personsRepository, PersonService personService) {
		this.personsRepository = personsRepository;
		this.personService = personService;
	}

	@PostMapping//позначає метод контролера, який повинен реагувати на POST-запити на вказаний шлях
	public void createPerson(@RequestBody Person person) {
		//save person to the db
		personsRepository.save(person);
	}

	@GetMapping("/{id}")
	public Optional<Person> getPerson(@PathVariable Long id){
		return personService.getPerson(id);
	}

	@DeleteMapping("/{id}")
//	TODO @PathVariable is missing
	public void removePerson(Long id) {
		personService.removePerson(id);
	}

	@GetMapping
	public List<Person> getAllPersons(){
		return personService.getAllPersons();
	}

	@PutMapping("/{id}")
	//TODO not a good practice to consume or return entities directly in controller
	//TODO use DTO instead
	//TODO use CTRL + ALT + L to correct code format
	//	TODO @PathVariable is missing
	public Optional<Person> updatePerson(Long id, @RequestBody Person personDetails){
		return personService.updatePerson(id, personDetails);
	}
}
