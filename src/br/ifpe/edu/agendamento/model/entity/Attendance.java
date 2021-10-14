package br.ifpe.edu.agendamento.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author Mikaelbr073
 *
 */
@Entity
@SequenceGenerator(name = "seq_attendance", sequenceName = "seq_attendance")
public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_attendance")
	private Person person;
	private Day day;
	private Service service;
	
	public Attendance() {
			
	}

	public Attendance(Person person, Day day, Service service) {
		this.person = person;
		this.day = day;
		this.service = service;
	}

	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public Person getPerson() {
		return person;
	}

	public Service getService() {
		return service;
	}
	
	
	
	
}
