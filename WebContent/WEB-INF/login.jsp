<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>

<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<title>Insert title here</title>

</head>

<body>

	<table id="menu">
		<tr>
			<td><a href="" id="linke">Login</a></td>
			<td><a href="login.do" id="linkc">Entrar</a></td>
			<td><a href="" id="linkd">Cadastro</a></td>
			<td><a href="Professor.jsp" id="linka">Professor</a></td>
			<td><a href="cadastroAluno.do" id="linkb">Aluno</a></td>
		</tr>

	</table>

	<form action="efetuarLogon.do" method="post">

		<fieldset id="fieldset1">

			<div id="login">

				<label for="login">Nome do usuário</label>

				<c:choose>

					<c:when test="${not empty requestScope.ERRO_ACESSO_NEGADO}">
						<input type="text" name="login" id="login"
							value="${requestScope.ERRO_ACESSO_NEGADO }"
							placeholder="Informe seu nome..." size="30" />

					</c:when>

					<c:otherwise>

						<input type="text" name="login" id="login"
							placeholder="Informe seu nome..." size="30" />

					</c:otherwise>

				</c:choose>

			</div>

			<div>

				<label for="senha">Senha</label> <input type="password" id="senha"
					name="senha" size="30" placeholder="Informe sua senha..." />

			</div>

			<p>

				<a href="solicitaSenha.do" id="linksenha">Esqueceu sua senha ?</a>

			</p>

			<fieldset id="fieldset2">

				<input type="checkbox" name="opcao" id="opcao" /> <label
					for="opcao">Mantenha-me logado</label> <input type="submit"
					name="login" id="login" value="Login" />

			</fieldset>

		</fieldset>

	</form>

</body>

</html>