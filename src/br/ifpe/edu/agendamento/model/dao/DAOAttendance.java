package br.ifpe.edu.agendamento.model.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import br.ifpe.edu.agendamento.model.entity.Attendance;

/**
 * @author JJunio
 *
 */
public class DAOAttendance extends DAOGenericImplements<Attendance> {

	@Override
	public boolean add(Attendance attendance) {
		DAOGenericImplements<Attendance> daoAttendance = new DAOGenericImplements<>();
		if (daoAttendance.add(attendance))
			return true;
		return false;
	}

	@Override
	public boolean update(Attendance attendance) {
		DAOGenericImplements<Attendance> daoAttendance = new DAOGenericImplements<>();

		DAOPostgreSQL.getInstance();
		Session session = DAOPostgreSQL.startTransaction();
		try {
			Attendance attendanceUpdate = readPersonCPF(attendance.getPerson().getCpf());
			if (daoAttendance.update(attendanceUpdate))
				return true;
			return false;
		} catch (Exception e) {
			System.out.println("Erro ao salvar" + e);
		}
		DAOPostgreSQL.closeTransaction(session);
		return false;
	}

	@Override
	public boolean clear(Attendance attendance) {
		DAOGenericImplements<Attendance> daoPerson = new DAOGenericImplements<>();

		DAOPostgreSQL.getInstance();
		Session session = DAOPostgreSQL.startTransaction();
		try {
			Attendance attendanceClear = readPersonCPF(attendance.getPerson().getCpf());
			if (daoPerson.clear(attendanceClear))
				return true;
			return false;
		} catch (Exception e) {
			System.out.println("Erro ao salvar" + e);
		}
		DAOPostgreSQL.closeTransaction(session);
		return false;
	}

	public List<Attendance> listAll() {
		DAOPostgreSQL.getInstance();
		Session session = DAOPostgreSQL.startTransaction();
		List<Attendance> attendances = null;
		try {
			Query consulta = session.createQuery("from Attendance");
			attendances = (List<Attendance>) consulta.getResultList();
		} catch (Exception err) {
			System.out.println("erro" + err);
		}
		DAOPostgreSQL.closeTransaction(session);
		return attendances;
	}

	public Attendance readPersonCPF(String CPF) {
		DAOPostgreSQL.getInstance();
		Session session = DAOPostgreSQL.startTransaction();
		Attendance attendance = null;
		try {
			Query consulta = session.createQuery("from Attendance attendance JOIN Person where attendance.cpf like '" + CPF + "'");
			attendance = (Attendance) consulta.getResultList().get(0);
		} catch (Exception err) {
			System.out.println("erro" + err);
		}
		DAOPostgreSQL.closeTransaction(session);
		return attendance;
	}
	
	public List<Attendance> listAllDate(Date date) {
		List<Attendance> attendancesDate = null;
		
		DAOPostgreSQL.getInstance();
		Session session = DAOPostgreSQL.startTransaction();
		try {
			Query consulta = session.createQuery("from Attendance ");
			attendancesDate = (List<Attendance>) consulta.getResultList();
		} catch (Exception err) {
			System.out.println("erro" + err);
		}
		DAOPostgreSQL.closeTransaction(session);
		
		return attendancesDate;
	}
}