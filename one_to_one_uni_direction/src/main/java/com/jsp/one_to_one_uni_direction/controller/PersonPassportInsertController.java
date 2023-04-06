package com.jsp.one_to_one_uni_direction.controller;

import java.time.LocalDateTime;

import com.jsp.one_to_one_uni_direction.dto.Passport;
import com.jsp.one_to_one_uni_direction.dto.Person;
import com.jsp.one_to_one_uni_direction.service.PersonService;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersonPassportInsertController {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("1.Insert\n2.Search\n3.Delete\n4.Update\n5.Display\n6.Display\n7.Update\n8.Exit");
			System.out.println("Enter your choice: ");
			int choice = s.nextInt();
			switch (choice) {
			case 1: {

				Passport passport = new Passport();
				System.out.println("enter passportId: ");
				passport.setPassportId(s.nextInt());
				System.out.println("enter passsport color: ");
				passport.setPassportColor(s.next());
				System.out.println("enter passport type: ");
				passport.setPassportType(s.next());
				Person person = new Person();
				System.out.println("enter personId: ");
				person.setPersonId(s.nextInt());
				System.out.println("enter personName: ");
				person.setPersonName(s.next());
				System.out.println("enter person age: ");
				person.setPersonAge(s.nextInt());
				person.setPassport(passport);
				PersonService personService = new PersonService();
				personService.savePassportPerson(passport, person);
			}
				break;
			case 2: {
				PersonService personService = new PersonService();
				System.out.println("enter personId: ");
				Person person = personService.getByIdPerson(s.nextInt());
				if (person != null) {
					System.out.println("-----------------------------person details----------------------");
					System.out.println("personId: " + person.getPersonId());
					System.out.println("personName: " + person.getPersonName());
					System.out.println("personAge: " + person.getPersonAge());
					System.out.println("-----------------------------passport details----------------------");
					System.out.println("passportId: " + person.getPassport().getPassportId());
					System.out.println("passportColor: " + person.getPassport().getPassportColor());
					System.out.println("passportType: " + person.getPassport().getPassportType());
					System.out.println("LocalDateTime: " + person.getPassport().getDateTime());
					System.out.println("");
				} else {
					System.out.println("id is not present in database or already has been deleted");
				}
			}
				break;

			case 3: {
				PersonService personService = new PersonService();
				System.out.println("enter personId to delete that particular data: ");
				personService.deletePassportPerson(s.nextInt());
			}
				break;

			case 4: {
				PersonService personService = new PersonService();
				Person person = new Person();
				System.out.println("enter personId");
				person.setPersonId(s.nextInt());
				System.out.println("enter personName");
				person.setPersonName(s.next());
				System.out.println("enter personAge");
				person.setPersonAge(s.nextInt());
				Passport passport = new Passport();
				System.out.println("enter passportId");
				passport.setPassportId(s.nextInt());
				System.out.println("enter passportColor");
				passport.setPassportColor(s.next());
				System.out.println("enter passportType");
				passport.setPassportType(s.next());
				person.setPassport(passport);
				personService.updatePassportPerson(person);
			}
				break;
			case 5: {
//				List<Person> list = personService.display();
				PersonService personService = new PersonService();
				for (Person disp : personService.display()) {
					System.out.println("-----------------------Person Details----------------------------");
					System.out.println("personId: " + disp.getPersonId());
					System.out.println("personName: " + disp.getPersonName());
					System.out.println("personAge: " + disp.getPersonAge());
					System.out.println(".........................Passport Details..........................");
					System.out.println("passportNumber: " + disp.getPassport().getPassportId());
					System.out.println("passportColor: " + disp.getPassport().getPassportColor());
					System.out.println("passportType: " + disp.getPassport().getPassportType());
					System.out.println("");
				}

			}
				break;
			case 6: {
				PersonService personService = new PersonService();
				List<Person> persons = personService.getAllPersonPassport();
				for (Person person : persons) {
					Passport passport = person.getPassport();
					if (passport != null) {
						System.out.println(".........................Passport Details..........................");
						System.out.println("passportNumber: " + passport.getPassportId());
						System.out.println("passportColor: " + passport.getPassportColor());
						System.out.println("passportType: " + passport.getPassportType());
						System.out.println("passportDate: " + passport.getDateTime().getDayOfMonth());
					}
					System.out.println("-----------------------Person Details----------------------------");
					System.out.println("personId: " + person.getPersonId());
					System.out.println("personName: " + person.getPersonName());
					System.out.println("personAge: " + person.getPersonAge());
					System.out.println("");
				}

			}
				break;

			case 7: {
				PersonService personService = new PersonService();
				System.out.println("enter personId: ");
				int personId = s.nextInt();
				System.out.println("enter personName: ");
				String personName = s.next();
				System.out.println("enter passportType: ");
				String passportType = s.next();
				personService.updatePersonPassport(personId, personName, passportType);
			}break;
			case 8: {
				System.out.println("System closed successfully...");
				System.exit(choice);

			}
				break;

			default: {
				System.out.println("invalid choice please try again");
			}
			}
		}

	}

}
