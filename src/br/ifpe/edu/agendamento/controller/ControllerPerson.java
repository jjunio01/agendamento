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

/**
 * Servlet implementation class ControllerPerson
 */
@WebServlet("/ControllerPerson")
public class ControllerPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ControllerPerson() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset-UTF-8");

		String name = request.getParameter("name");
		String cpf = request.getParameter("cpf");
		String phoneNumber = request.getParameter("phoneNumber");
		String emailEddress = request.getParameter("emailEddress");

		String mensagemCadastro = "Cadastro realizado com sucesso!";
		Person person = new Person(cpf, name, phoneNumber, emailEddress);
		if (ModelPerson.createPerson(person)) {
			request.setAttribute("mensagem", mensagemCadastro);
		} else {
			request.setAttribute("mensagem", mensagemCadastro);
			mensagemCadastro = "Falha ao realizar cadastro, tente novamente.";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);

	}

}
