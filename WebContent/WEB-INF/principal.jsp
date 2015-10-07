<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<script src="js/jquery.js"></script>
<script src="js/jquery-ui.js"></script>
<script>
	$(function() {
		$("#menu").menu();
	});
</script>
<title>Sistema de Monitoria</title>
</head>
<body>
	<div id="page">
		<article> <header id="cabecalho"> <img
			src="css/images/tads.png" /> <nav>
		<ul id="menu">
			<li>Login
				<ul>
					<li><a href="login.do">Entrar</a></li>
				</ul>
			</li>
			<li>Cadastro
				<ul>
					<li><a>Professor</a></li>
					<li><a>Aluno</a></li>
				</ul>
			</li>
		</ul>
		</nav> </header> </article>
	</div>
</body>
</html>