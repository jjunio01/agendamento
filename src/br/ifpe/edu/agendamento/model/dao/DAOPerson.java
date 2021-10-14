package br.ifpe.edu.agendamento.model.dao;

import java.util.List;

import org.hibernate.Session;

import br.ifpe.edu.agendamento.model.entity.Person;

/**
 * @author JJunio
 *
 */
public class DAOPerson implements DAOGeneric<Person> {

	@Override
	public boolean add(Person person) {
		DAOPostgreSQL.getInstance();
		Session session = DAOPostgreSQL.startTransaction();
		try {
			session.save(person);
			return true;
		} catch (Exception e) {
			System.out.println("Erro ao salvar" + e);
		}
		DAOPostgreSQL.closeTransaction(session);
		return false;
	}

	@Override
	public boolean update(Person person) {
		DAOPostgreSQL.getInstance();
		Session session = DAOPostgreSQL.startTransaction();
		try {
			session.update(person);
			return true;
		} catch (Exception e) {
			System.out.println("Erro ao atualizar" + e);
		}
		DAOPostgreSQL.closeTransaction(session);
		return false;
	}

	@Override
	public boolean clear(Person person) {
		DAOPostgreSQL.getInstance();
		Session session = DAOPostgreSQL.startTransaction();
		try {
			session.delete(person);
			return true;
		} catch (Exception e) {
			System.out.println("Erro ao salvar" + e);
		}
		DAOPostgreSQL.closeTransaction(session);
		return false;
	}

	@Override
	public List<Person> listAll() {
		return null;
	}
}
