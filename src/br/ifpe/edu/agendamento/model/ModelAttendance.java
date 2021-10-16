package br.ifpe.edu.agendamento.model;

import java.sql.Date;
import java.util.List;

import br.ifpe.edu.agendamento.model.dao.DAOAttendance;
import br.ifpe.edu.agendamento.model.entity.Attendance;

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

		if (attendance != null) {

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
