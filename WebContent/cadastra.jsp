<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style-cadastro.css">
    <link rel="stylesheet" href="css/style-index.css">
    <title>Cadastra</title>
</head>
<body>
    <body>

        <div class="formulario">
            <form action="cadastrar" method="post" class="formulario-interno">

                <h2 class="titulo">Cadastra</h2>

                <div>
                    <label for="inputNome">Nome Completo:</label>
                    <input type="text" id="inputNome" name="name"
                    placeholder="Ex:Mikael Crvalho" required >   
                      
                </div>
               
                <div>
                    <label for="inputcpf">CPF:</label>
                    <input type="text" id="inputcpf" name="cpf" 
                     placeholder="Ex:75123055567" required>
                </div>

                <div>
                    <label for="inputcelular">Celular:</label>
                    <input type="number" id="inputcelular" name="phoneNumber" 
                    placeholder="Ex:87996771179" required>
                    
                </div>

                <div>
                    <label for="inputemail">e-mail:</label>
                    <input type="email" id="inputemail" 
                     placeholder="pedrolucas@emial.com"  name="emailEddress">
                   
                </div>

                <div class="botao-formulario"></div>
                    <input id="cadastra" type="submit" name="salvar"
					value="Cadastrar">
                </div>
                
            </form>


        </div> 

    </body>
</body>
</html>
