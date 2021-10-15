package br.ifpe.edu.agendamento.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import br.ifpe.edu.agendamento.model.dao.DAOPostgreSQL;
import br.ifpe.edu.agendamento.model.entity.Person;
import br.ifpe.edu.agendamento.model.entity.Queue;

/**
 * Servlet implementation class ControllerPerson
 */
@WebServlet("/ControllerPerson")
public class ControllerPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerPerson() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset-UTF-8");
		System.out.println("Vamo lá");
		
		Queue fila = new Queue();
		DAOPostgreSQL.getInstance();
		Session session = DAOPostgreSQL.startTransaction();
		session.save(fila);
		DAOPostgreSQL.closeTransaction(session);
	}

}
