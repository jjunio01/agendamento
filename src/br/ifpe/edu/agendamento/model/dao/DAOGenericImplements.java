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
		} catch (Exception e) {
			System.out.println("Erro ao salvar" + e);
			return false;
		}
		DAOPostgreSQL.closeTransaction(session);
		return true;
	}

	@Override
	public boolean update(T t) {
		DAOPostgreSQL.getInstance();
		Session session = DAOPostgreSQL.startTransaction();
		try {
			session.update(t);
		} catch (Exception e) {
			System.out.println("Erro ao atualizar" + e);
			return false;
		}
		DAOPostgreSQL.closeTransaction(session);
		return true;
	}

	@Override
	public boolean clear(T t) {
		DAOPostgreSQL.getInstance();
		Session session = DAOPostgreSQL.startTransaction();
		try {
			session.delete(t);
		} catch (Exception e) {
			System.out.println("Erro ao salvar" + e);
			return false;
		}
		DAOPostgreSQL.closeTransaction(session);
		return true;
	}

}
