package br.ifpe.edu.agendamento.model.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import br.ifpe.edu.agendamento.model.entity.Attendance;
import br.ifpe.edu.agendamento.model.entity.QueueAttendance;

/**
 * @author JJunio
 *
 */
public class DAOQueueAttendance {

	public QueueAttendance getQueue() {
		DAOPostgreSQL.getInstance();
		Session session = DAOPostgreSQL.startTransaction();
		List<QueueAttendance> queueAttendances = null;
		try {
			Query consulta = session.createQuery("from QueueAttendance");
			queueAttendances = (List<QueueAttendance>) consulta.getResultList();

			if (!queueAttendances.isEmpty()) {
				return queueAttendances.get(0);
			}
		} catch (Exception err) {
			System.out.println("erro" + err);
		}
		DAOPostgreSQL.closeTransaction(session);
		return null;
	}

	public boolean add(Attendance attendance) {

		QueueAttendance result = getQueue();
		DAOPostgreSQL.getInstance();
		Session session = DAOPostgreSQL.startTransaction();
		try {
			if (result == null) {
				result = new QueueAttendance();
				result.updateQueueAttendances(attendance);
				session.save(result);
			} else {
				result.updateQueueAttendances(attendance);
				session.update(result);
			}

		} catch (Exception e) {
			System.out.println("Erro ao salvar" + e);
			return false;
		}
		DAOPostgreSQL.closeTransaction(session);
		return true;
	}
}
