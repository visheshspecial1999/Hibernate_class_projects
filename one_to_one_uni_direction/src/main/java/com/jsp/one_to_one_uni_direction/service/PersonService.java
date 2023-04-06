package com.jsp.one_to_one_uni_direction.service;

import java.util.List;

import com.jsp.one_to_one_uni_direction.dao.PersonDao;
import com.jsp.one_to_one_uni_direction.dto.Passport;
import com.jsp.one_to_one_uni_direction.dto.Person;

public class PersonService {

	PersonDao personDao = new PersonDao();

	public void savePassportPerson(Passport passport, Person person) {
		personDao.savePassportPerson(passport, person);
	}

	public Person getByIdPerson(int personId) {
		if (personDao.getByIdPerson(personId) != null) {
			return personDao.getByIdPerson(personId);
		} else {
			return null;
		}
	}

	public void deletePassportPerson(int personId) {
		Person person = personDao.getByIdPerson(personId);
		if (person != null) {
			if (person.getPassport() != null) {
				if (person.getPersonId() == personId) {
					personDao.deletePassportPerson(personId);
				} else {
					System.out.println("personId is not present in database");
				}

			} else {
				System.out.println("passportNumber is not  avaliable in database");
			}
		} else {
			System.out.println("person is null");
		}

	}

	public void updatePassportPerson(Person person) {
		Person person2 = personDao.getByIdPerson(person.getPersonId());
		if (person2 != null) {
			if (person2.getPersonId() == person.getPersonId()) {
				if (person2.getPassport().getPassportId() == person.getPassport().getPassportId()) {

					personDao.updatePassportPerson(person);
				} else {
					System.out.println("passport number does not match");
				}
			} else {
				System.out.println("personId does not match");
			}
		} else {
			System.out.println("personId is not present in database");
		}
	}
	
	public List<Person> display(){
		return personDao.display();
	}
	

	// display method 2
	public List<Person>getAllPersonPassport(){
		return personDao.getAllPersonPassport();
	}
	
	public void updatePersonPassport(int personId,String PersonName,String passportType)
	{
		personDao.updatePersonPassport(personId, PersonName, passportType);
	}
}
