package br.ifpe.edu.agendamento.model.dao;

import org.hibernate.Session;

/**
 * @author JJunio
 *
 */
public class DAOGenericImplements<T> implements DAOGeneric<T> {

	public DAOGenericImplements() {
	}

	@Override
	public boolean add(T t) {
		DAOPostgreSQL.getInstance();
		Session session = DAOPostgreSQL.startTransaction();
		try {
			session.save(t);
			return true;
		} catch (Exception e) {
			System.out.println("Erro ao salvar" + e);
		}
		DAOPostgreSQL.closeTransaction(session);
		return false;
	}

	@Override
	public boolean update(T t) {
		DAOPostgreSQL.getInstance();
		Session session = DAOPostgreSQL.startTransaction();
		try {
			session.update(t);
			return true;
		} catch (Exception e) {
			System.out.println("Erro ao atualizar" + e);
		}
		DAOPostgreSQL.closeTransaction(session);
		return false;
	}

	@Override
	public boolean clear(T t) {
		DAOPostgreSQL.getInstance();
		Session session = DAOPostgreSQL.startTransaction();
		try {
			session.delete(t);
			return true;
		} catch (Exception e) {
			System.out.println("Erro ao salvar" + e);
		}
		DAOPostgreSQL.closeTransaction(session);
		return false;
	}

}
