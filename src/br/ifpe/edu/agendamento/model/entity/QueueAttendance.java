package br.ifpe.edu.agendamento.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
		this.queueAttendances = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public List<Attendance> getQueueAttendances() {
		return queueAttendances;
	}

	public void updateQueueAttendances(Attendance attendance) {
		this.queueAttendances.add(attendance);
	}

}
