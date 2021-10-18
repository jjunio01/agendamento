package br.ifpe.edu.agendamento.controller;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifpe.edu.agendamento.model.ModelAttendance;
import br.ifpe.edu.agendamento.model.ModelPerson;
import br.ifpe.edu.agendamento.model.ModelQueue;
import br.ifpe.edu.agendamento.model.entity.Attendance;
import br.ifpe.edu.agendamento.model.entity.Day;
import br.ifpe.edu.agendamento.model.entity.Person;
import br.ifpe.edu.agendamento.model.entity.QueueAttendance;
import br.ifpe.edu.agendamento.model.entity.Service;

/**
 * Servlet implementation class ControllerQueue
 */
@WebServlet("/ControllerQueue")
public class ControllerQueue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerQueue() {
        super(); 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		QueueAttendance queue = ModelQueue.getQueue();
		List<Attendance> attendances = queue.getQueueAttendances();
		request.setAttribute( "nome", attendances ); request.getRequestDispatcher( "/listagem.jsp" ).forward( request, response );
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		String cpf = request.getParameter("cpf");
		Service servico = Service.DERMATOLOGIA;
		Day data = new Day(new Date(), new Date());

		String mensagemCadastro = "Serviço agendado com sucesso!";
		Person person = ModelPerson.readPersonForCPF(cpf);
		if (person != null) {
			
			Attendance attendance = new Attendance(person, data, servico);
			ModelAttendance.createAttendance(attendance);
			ModelQueue.addAttendanceQueue(attendance);
		} else {
			mensagemCadastro = "Usuário não cadastrado. Favor realize o cadastro antes de soliciar o serviço.";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("listagem.jsp");
		dispatcher.forward(request, response);
	}

}
