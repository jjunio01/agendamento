package br.ifpe.edu.agendamento.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Mikaelbr073
 *
 */

@Entity
@SequenceGenerator(name = "seq_person", sequenceName = "seq_person", initialValue = 1, allocationSize = 1)
@Table(uniqueConstraints = @UniqueConstraint(name = "phoneNumber", columnNames = {"phoneNumber"}))
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_person")
	private String cpf;
	@OneToOne
	@JoinColumn(name="attendance_name", foreignKey = @ForeignKey(name="fk_attendance"))
	private String name;
	@Column(unique = true)
	private String phoneNumber;
	private String emailEddress;

	public Person() {

	}

	public Person(String cpf, String name, String phoneNumber, String emailEddress) {
		this.cpf = cpf;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.emailEddress = emailEddress;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailEddress() {
		return emailEddress;
	}

	public void setEmailEddress(String emailEddress) {
		this.emailEddress = emailEddress;
	}

}
