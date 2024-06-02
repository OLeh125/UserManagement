package com.nazar.user_Managment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nazar.user_Managment.entity.Person;
import com.nazar.user_Managment.repository.PersonsRepository;

@Service
public class PersonService {
//TODO fix type perons
	private final PersonsRepository peronsRepository;

	public PersonService(PersonsRepository peronsRepository) {
		this.peronsRepository = peronsRepository;
	}
	//отримати персона(за id наприклад)
	@Transactional(readOnly = true)//тільки читаються данні
	public Optional<Person> getPerson(Long id) {
		return peronsRepository.findById(id);
	}

	//видалити (за id наприклад)
	//TODO Transactional could be moved on class level and override with @Transactional(readOnly = true) on readOnly methods
	@Transactional
	public void removePerson(Long id) {
		peronsRepository.deleteById(id);
	}

	//getAll
	@Transactional(readOnly = true)
	public List<Person> getAllPersons() {
		return peronsRepository.findAll();
	}
	//оновлення юзера
	@Transactional
    public Optional<Person> updatePerson(Long id, Person personDetails) {
        return peronsRepository.findById(id).map(person -> {
            person.setEmail(personDetails.getEmail());
            person.setFirstName(personDetails.getFirstName());
            person.setLastName(personDetails.getLastName());
            person.setAge(personDetails.getAge());
            person.setRole(personDetails.getRole());
            peronsRepository.save(person);
            return person;
        });
    }
}
