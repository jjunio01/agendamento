package br.ifpe.edu.agendamento.model.entity;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * @author Mikaelbr073
 *
 */
@Entity
public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	
	@OneToOne
	private Person person;
	
	@Embedded
	private Day day;
	
	@Enumerated(EnumType.ORDINAL)
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

	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	
	
}
