<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<script>
	//evento links

	$(document).ready(function() {
		$("[href]").css("color", "white");
		$("#linka").mouseover(function() {

			$("#linka").css("color", "deeppink");

		});

		$("#linkb").mouseover(function() {

			$("#linkb").css("color", "deeppink");

		});

		$("#linkc").mouseover(function() {

			$("#linkc").css("color", "deeppink");

		});

		$("#linkd").mouseover(function() {

			$("#linkd").css("color", "deeppink");

		});

		$("#linke").mouseover(function() {

			$("#linke").css("color", "deeppink");

		});

		$("[href]").mouseout(function() {

			$("[href]").css("color", "white");

		});

	});
</script>
<title>Insert title here</title>
</head>
<body>

	<table id="menu">

		<tr>

			<td><a href="" id="linke">Login</a></td>
			<td><a href="login.do" id="linkc">Entrar</a></td>
			<td><a href="" id="linkd">Cadastro</a></td>
			<td><a href="professor.jps" id="linka">Professor</a></td>
			<td><a href="" id="linkb">Aluno</a></td>

		</tr>

	</table>
	<br />
	<form action="requisitarSenha.do" method="post">
		<fieldset id="fieldset1">

			<div id="login">

				<label for="login1">Login do usuário: </label>

				<c:choose>

					<c:when test="${not empty requestScope.ERRO_ACESSO_NEGADO}">
						<input type="text" name="login" id="login1"
							value="${requestScope.ERRO_ACESSO_NEGADO }"
							placeholder="Informe seu nome..." size="30" />

					</c:when>

					<c:otherwise>
						<input type="text" name="login" id="login1"
							placeholder="Informe seu nome..." size="30" />
					</c:otherwise>

				</c:choose>

			</div>
			<br />
			<fieldset id="fieldset2">
				<input type="submit" name="login" id="login1" value="Solicitar senha" />
			</fieldset>

		</fieldset>
	</form>


</body>
</html>