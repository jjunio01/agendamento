package br.ifpe.edu.agendamento.model.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Mikaelbr073
 *
 */

@Entity
public class QueueAttendance {

	@Id
	@GeneratedValue
	private int id;
	@OneToMany
	private List<Attendance> queueAttendances;
	

	public QueueAttendance() {
	}

	public void setQueueAttendances(LinkedList<Attendance> queueAttendances) {
		this.queueAttendances = queueAttendances;
	}

	public int getId() {
		return id;
	}

	public List<Attendance> getQueueAttendances() {
		return queueAttendances;
	}

}
