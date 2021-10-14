package br.ifpe.edu.agendamento.model.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.JDBCConnectionException;

/**
 * @author JJunio
 *
 */
public class DAOPostgreSQL {

	private static DAOPostgreSQL connectionPostgreSQL;

	private DAOPostgreSQL() {

	}

	public static DAOPostgreSQL getInstance() {
		if (connectionPostgreSQL == null) {
			connectionPostgreSQL = new DAOPostgreSQL();
		}

		return connectionPostgreSQL;
	}

	private Session openSession() {

		SessionFactory factory = null;
		Session session = null;
		try {
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			session = factory.openSession();
		} catch (JDBCConnectionException errorOpenSession) {
			System.out.println("Não foi possível abrir a conexão com o banco de dados" + errorOpenSession);

		}
		return session;
	}
	
	public static Session startTransaction() {
		Session session = DAOPostgreSQL.getInstance().openSession();
		
		try {
            session.beginTransaction();
        } catch (Exception e) {
		System.out.println("erro ao inicar transação " + e);
		}
        return session;
	}
	
	public static void closeTransaction(Session session) {
		try {
            session.getTransaction().commit();
        } catch (NullPointerException erroFecharTransacao) {
            erroFecharTransacao.printStackTrace();
        }
        session.close();
	}
}
