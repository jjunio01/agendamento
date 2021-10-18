package br.ifpe.edu.agendamento.model;

import java.util.List;

import br.ifpe.edu.agendamento.model.dao.DAOQueueAttendance;
import br.ifpe.edu.agendamento.model.entity.Attendance;
import br.ifpe.edu.agendamento.model.entity.QueueAttendance;

/**
 * @author JJunio
 *
 */
public class ModelQueue {

	public static boolean addAttendanceQueue(Attendance attendance) {

		DAOQueueAttendance daoQueue = new DAOQueueAttendance();

		if (attendance != null) {
			daoQueue.add(attendance);
			return true;
		}
		return false;
	}

	public static QueueAttendance getQueue() {
		return new DAOQueueAttendance().getQueue();
	}
}
