<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="css/jquery-ui.css" type="text/css" />
<script src="js/jquery-ui-1.11.4/external/jquery/jquery.js"></script>
<script src="js/jquery-ui-1.11.4/jquery-ui.js"></script>
<script src="js/trocar-persistencia.js"></script>
<link rel="stylesheet" type="text/css" href="css/cabecalho.css" />
<link rel="stylesheet" type="text/css" href="css/toggle-button.css" />

</head>
<body>
	<!--Header Begin-->
	<div id="header">
		<c:choose>
			<c:when test="${not empty requestScope.ERRO_ACESSO_NEGADO}">

				<div class="ui-widget">
					<div class="ui-state-error ui-corner-all"
						style="padding: 0 .7em; background-color: red;">
						<p>
							<span class="ui-icon ui-icon-alert"
								style="float: right; margin-right: .3em;"></span> <strong>Alert:</strong>
							${requestScope.ERRO_ACESSO_NEGADO }
						</p>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="center">
					<div id="logo">
						<a href="acesso.do">Monitoria IFPE-TADS</a>
					</div>
					<!--Menu Begin-->
					<div id="menu">
						<ul>
							<li><a class="active" href="acesso.do"><span>Home</span> </a></li>
							<li><a class="active" href="cadastroAluno.do"><span>Aluno</span> </a></li>
							<li><a class="active" href="cadastroProfessor.do"><span>Professor</span> </a></li>
							<!--  <li><a href="#" class="toggler">JPA</a></li> -->
						</ul>
					</div>
					<!--Menu END-->
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	<!--Header END-->
	<!--Toprow Begin-->
	<div id="toprow">
		<div class="center">
			<div id="cubershadow">
</body>
</html>