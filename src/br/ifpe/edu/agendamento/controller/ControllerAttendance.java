package br.ifpe.edu.agendamento.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ifpe.edu.agendamento.model.ModelAttendance;
import br.ifpe.edu.agendamento.model.ModelPerson;
import br.ifpe.edu.agendamento.model.entity.Attendance;
import br.ifpe.edu.agendamento.model.entity.Day;
import br.ifpe.edu.agendamento.model.entity.Person;
import br.ifpe.edu.agendamento.model.entity.Service;
import sun.java2d.d3d.D3DDrawImage;

/**
 * Servlet implementation class ControllerAttendance
 */
@WebServlet("/ControllerAttendance")
public class ControllerAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ControllerAttendance() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset-UTF-8");

		String cpf = request.getParameter("cpf");
		Service servico = Service.DERMATOLOGIA;
		Day data = new Day(new Date(), new Date());

		String mensagemCadastro = "Serviço agendado com sucesso!";
		Person person = ModelPerson.readPersonForCPF(cpf);
		if (person != null) {
			Attendance attendance = new Attendance(person, data, servico);
			ModelAttendance.createAttendance(attendance);
		} else {
			mensagemCadastro = "Usuário não cadastrado. Favor realize o cadastro antes de soliciar o serviço.";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

}
