package br.ifpe.edu.agendamento.model.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import br.ifpe.edu.agendamento.model.entity.Person;

/**
 * @author JJunio
 *
 */
public class DAOPerson extends DAOGenericImplements<Person> {

	@Override
	public boolean add(Person person) {
		DAOGenericImplements<Person> daoPerson = new DAOGenericImplements<>();
		if (daoPerson.add(person))
			return true;
		return false;
	}

	@Override
	public boolean update(Person person) {
		DAOGenericImplements<Person> daoPerson = new DAOGenericImplements<>();

		DAOPostgreSQL.getInstance();
		Session session = DAOPostgreSQL.startTransaction();
		try {
			Person personUpdate = readCPF(person.getCpf());
			daoPerson.update(personUpdate);
		} catch (Exception e) {
			System.out.println("Erro ao salvar" + e);
			return false;
		}
		DAOPostgreSQL.closeTransaction(session);
		return true;
	}

	@Override
	public boolean clear(Person person) {
		DAOGenericImplements<Person> daoPerson = new DAOGenericImplements<>();

		DAOPostgreSQL.getInstance();
		Session session = DAOPostgreSQL.startTransaction();
		try {
			Person personClear = readCPF(person.getCpf());
			daoPerson.clear(personClear);
		} catch (Exception e) {
			System.out.println("Erro ao salvar" + e);
			return false;
		}
		DAOPostgreSQL.closeTransaction(session);
		return true;
	}

	public List<Person> listAll() {
		DAOPostgreSQL.getInstance();
		Session session = DAOPostgreSQL.startTransaction();
		List<Person> persons = null;
		try {
			Query consulta = session.createQuery("from Person");
			persons = consulta.getResultList();
		} catch (Exception err) {
			System.out.println("erro" + err);
		}
		DAOPostgreSQL.closeTransaction(session);
		return persons;
	}

	public Person readCPF(String CPF) {
		DAOPostgreSQL.getInstance();
		Session session = DAOPostgreSQL.startTransaction();
		Person person = null;
		try {
			Query consult = session.createQuery("from Person where cpf = '" + CPF + "'", Person.class);
			List<Person> result = (List<Person>)  consult.getResultList();
			if (!result.isEmpty()) {
				person = result.get(0);
				return person;
			}
		} catch (Exception err) {
			System.out.println("erro" + err);
		}
		DAOPostgreSQL.closeTransaction(session);
		return person;

	}
}
