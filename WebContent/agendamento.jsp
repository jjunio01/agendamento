<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style-index.css">
    <link rel="stylesheet" href="css/style-cadastro.css">
    <link rel="stylesheet" href="css/style-agendamento.css">
    <title>Agendamento</title>
</head>
<body>
    <body>
        <div class="formulario">

            <form action="cadastra" method="post" class="formulario-interno">

                <h2 class="titulo-agendamento">Agendamento</h2>

                <div>
                    <label for="inputcpf">CPF:</label>
                    <input type="text" id="inputcpf" name="cpf"
                     placeholder="Ex:75123055567" required >   
                </div>
               
                <div>
                    <label for="inputservico">Serviço:</label>
                    <input type="text" id="inputservico" name="servico" required>
                </div>

                <div>
                    <label for="inputdata">Data:</label>
                    <input type="datetime-local" id="inputdata" name="data" required>
                </div>

                <div class="botao-formulario"></div>
                    <input id="agendar" type="submit" name="salvar"
					value="Agendar">
                </div>
                
            </form>


        </div> 

    </body>
</body>
</html>