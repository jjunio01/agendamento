package br.ifpe.edu.agendamento.model.entity;

import java.util.Date;

/**
 * @author Mikaelbr073
 *
 */

public class Day {
	
	private Date date;
	private Date time;
	
	public Day() {
		
	}

	public Day(Date date, Date time) {
		this.date = date;
		this.time = time;
	}

	public Date getDate() {
		return date;
	}
	
	public Date getTime() {
		return time;
	}

	
	
	
	

}