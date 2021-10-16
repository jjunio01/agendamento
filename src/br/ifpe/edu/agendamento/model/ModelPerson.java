package br.ifpe.edu.agendamento.model;

import br.ifpe.edu.agendamento.model.dao.DAOPerson;
import br.ifpe.edu.agendamento.model.entity.Person;

/**
 * @author JJunio
 *
 */
public class ModelPerson {

	public static Person readPersonCPF(String CPF) {

		DAOPerson daoPerson = new DAOPerson();
		Person person = daoPerson.readCPF(CPF);

		return person;
	}

	public static boolean createPerson(Person person) {

		if (person != null) {

			if (person.getCpf().isEmpty() || person.getName().isEmpty() || person.getPhoneNumber().isEmpty()) {
				return false;
			}

			Person queryPerson = readPersonCPF(person.getCpf());

			if (queryPerson != null) {
				DAOPerson daoPerson = new DAOPerson();
				daoPerson.add(person);
				return true;
			}
		}

		return false;
	}
	
	public static boolean updatePerson(Person person) {
		
		if (person != null) {

			Person queryPerson = readPersonCPF(person.getCpf());

			if (queryPerson != null) {
				DAOPerson daoPerson = new DAOPerson();
				daoPerson.update(person);
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean clearPerson(String CPF) {
		
		Person queryPerson = readPersonCPF(CPF);
		
		if (queryPerson != null) {
			DAOPerson daoPerson = new DAOPerson();
			daoPerson.clear(queryPerson);
			return true;
		}
		
		return false;
	}
}
