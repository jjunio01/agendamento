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
@Table(uniqueConstraints = @UniqueConstraint(name = "phoneNumber", columnNames = {"phoneNumber"}))
public class Person {

	@Id
	private String cpf;
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
