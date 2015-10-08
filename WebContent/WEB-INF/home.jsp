<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Sistema Monitoria</title>
</head>
<body>
	
		<div id="page">
		<article> 
		<header id="cabecalho"> <img src="css/images/tads.png" /> 
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
		</nav> </header> </article>
	</div>
		
		
	<c:out value="Welcome ${sessionScope['usuarioLogado'].nome}"/>
	<p><a href="logout.do">Sair</a></p>
</body>
</html>