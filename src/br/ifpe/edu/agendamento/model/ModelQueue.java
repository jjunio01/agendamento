package br.ifpe.edu.agendamento.model;

import java.util.Queue;

import br.ifpe.edu.agendamento.model.dao.DAOQueueAttendance;
import br.ifpe.edu.agendamento.model.entity.Attendance;

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

	public static Queue<Attendance> getQueue() {
		return new DAOQueueAttendance().getQueue();
	}
}
