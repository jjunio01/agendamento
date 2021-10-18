package br.ifpe.edu.agendamento.model;

import java.util.Date;
import java.util.List;

import br.ifpe.edu.agendamento.model.dao.DAOAttendance;
import br.ifpe.edu.agendamento.model.dao.DAOPerson;
import br.ifpe.edu.agendamento.model.entity.Attendance;
import br.ifpe.edu.agendamento.model.entity.Person;

/**
 * @author JJunio
 *
 */
public class ModelAttendance {

	public static Attendance readAttendanceForPerson(String CPF) {

		DAOAttendance daoAttendance = new DAOAttendance();
		Attendance attendanceForPersonCPF = daoAttendance.readPersonCPF(CPF);

		return attendanceForPersonCPF;
	}

	public static boolean createAttendance(Attendance attendance) {

		DAOAttendance daoAttendance = new DAOAttendance();
		DAOPerson daoPerson = new DAOPerson();
		Person person = daoPerson.readCPF(attendance.getPerson().getCpf());
		attendance.setPerson(person);
		daoAttendance.add(attendance);
		if (attendance != null) {
			daoAttendance.add(attendance);
			if (attendance.getDay() == null || attendance.getPerson() == null || attendance.getService() == null) {
				return false;
			} else {
				if (ModelPerson.authenticatePerson(attendance.getPerson())) {

				}
			}
		}

		return false;
	}

	public static boolean checkAvailableDate(Date date) {

		return false;
	}

	public static boolean cancelAttendance(Attendance attendance) {

		DAOAttendance daoAttendance = new DAOAttendance();

		if (daoAttendance.readPersonCPF(attendance.getPerson().getCpf()) != null) {

			daoAttendance.clear(attendance);
		}

		return false;
	}

	public static List<Attendance> listAllDate(Date date) {

		return new DAOAttendance().listAllDate(date);
	}
}