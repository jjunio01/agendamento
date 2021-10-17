package br.ifpe.edu.agendamento.model.entity;

import java.util.LinkedList;
import java.util.Queue;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Mikaelbr073
 *
 */

@Entity
public class QueueAttendance {
	
	@Id
	@GeneratedValue
	private int id;
	private Queue<Attendance> queueAttendances;

	public QueueAttendance() {
		this.queueAttendances = new LinkedList<Attendance>();
	}

	public int getId() {
		return id;
	}

	public Queue<Attendance> getQueueAttendances() {
		return queueAttendances;
	}

}
