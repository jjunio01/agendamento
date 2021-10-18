<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="PT-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/style-index.css">

<title>Menu</title>
</head>
<body>
<body>

	<div class="sub-background">
		<h3 class="welcome">Bem-vindo!</h3>
		<a href="cadastra.jsp"><button class="cadastra">CADASTRA</button></a>
		<a href="agendamento.jsp"><button class="agendamento">AGENDAMENTO</button></a>
		<a href="listagem.jsp"><button class="listar">LISTA DE AGENDAMENTOS</button></a>
	</div>
	
	<div class="mensagem">
		<%
		String mensagem = (String) request.getAttribute("mensagem");
		if (mensagem != null)
			out.print(mensagem);
		%>
	</div>
	
</body>


<footer>
	<h3 class="copy">© 2012-2021, agendamento.com</h3>
</footer>

</body>
</html>