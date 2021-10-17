package br.ifpe.edu.agendamento.model.dao;

import java.util.LinkedList;
import java.util.Queue;

import javax.persistence.Query;

import org.hibernate.Session;

import br.ifpe.edu.agendamento.model.entity.Attendance;

/**
 * @author JJunio
 *
 */
public class DAOQueueAttendance {

	public Queue<Attendance> getQueue() {
		DAOPostgreSQL.getInstance();
		Session session = DAOPostgreSQL.startTransaction();
		Queue<Attendance> queueAttendances = new LinkedList<Attendance>();
		try {
			Query consulta = session.createQuery("from Attendance");
			queueAttendances = (LinkedList<Attendance>) consulta.getResultList();
		} catch (Exception err) {
			System.out.println("erro" + err);
		}
		DAOPostgreSQL.closeTransaction(session);
		return queueAttendances;
	}

	public boolean add(Attendance attendance) {

		Queue<Attendance> result = getQueue();

		DAOPostgreSQL.getInstance();
		Session session = DAOPostgreSQL.startTransaction();
		try {
			result.add(attendance);
			session.saveOrUpdate(result);
		} catch (Exception e) {
			System.out.println("Erro ao salvar" + e);
			return false;
		}
		DAOPostgreSQL.closeTransaction(session);
		return true;
	}
}
