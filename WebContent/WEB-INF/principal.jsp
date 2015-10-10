<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%> 

<!DOCTYPE html>

<html>

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/jquery-ui.css" rel="stylesheet">
	<link href="css/jquery-ui.min.css" rel="stylesheet">
	<link href="css/jquery-ui.theme.css" rel="stylesheet">
	<link href="css/jquery-ui.theme.min.css" rel="stylesheet">
	<link href="css/jquery-ui.structure.css" rel="stylesheet">
	<link href="css/jquery-ui.structure.min.css" rel="stylesheet">
	<link href="css/principal.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="menu.css" media="screen"/>
	<script src="js/jquery.js"></script>
	<script src="js/jquery-ui.js"></script>
	
	<script>
		$(function() {
			$("#menu").menu();
		});
	</script>
	
	<title>Sistema de Monitoria - Página Principal</title>

</head>

<body>

	<div id="page">
	
		<article> 
		
			<header id="cabecalho"> <img src="css/images/tads.png" alt="imagem tads"/>  </header>
			
			<nav>
			
				<table id="menu">
					
					<tr>
		            	
		            	<td>Login</td>
		                <td><a href="login.do" id="linkc">Entrar</a></td>
		                <td>Cadastro
		                <td><a href="" id="linka">Professor</a></td>
		                <td><a href="" id="linkb">Aluno</a></td>
		                        
		            </tr>
		            	
		        </table>
		        
			</nav>  
			
			</article>
			
	</div>
	
	<table id="rodape">
             
             <tr>
                 
                <td> <img src="logo-tads2.png" alt="logo do tads"/> </td>
                <td> <img src="ifpe.jpg" id="ifpe" alt="logo do ifpe"/> </td>
                
            </tr>
            
         </table>

</body>

</html>