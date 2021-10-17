<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style-listagem.css">
    <title>lista de agendamento</title>
</head>
<body>
    <body>
    
		<section id="listagem_id" class="listagem">
		
			<div class="titulo">
				<h1>Agendamentos</h1>
			</div>
			
			<table>
				<thead>
					<tr>
						<td>Nome</td>
						<td>CPF</td>
						<td>Dia</td>
						<td>Serviço</td>
						<td>Ação</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="" items="${}">
							<tr>
								<td>${}</td>
								<td>${}</td>
								<td>${}</td>
								<td>${}</td>
								<td><a href="">Editar</a></td>
								<td><a href="">Remover</a></td>
						
							</tr> 
					</c:forEach>
				</tbody>
			</table>
				
		</section>
      
       
    </body>
</body>
</html>
