<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link type="text/css" rel="stylesheet" href="/css/login.css" />
<title>Insert title here</title>
</head>
<body>
	<form action="efetuarLogon.do" method="post">

		<fieldset>
			<label for="login">Nome do usuario</label>
			<div>
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

			<label for="senha">Senha</label>
			<p>
				<a>Esqueceu sua senha ?</a>
			</p>
			<div>
				<input type="password" id="senha" name="senha" size="30"
					placeholder="Informe sua senha..." />
			</div>
		</fieldset>

		<fieldset>
			<input type="checkbox" name="opcao" id="opcao" /> <label for="opcao">Mantenha-me
				logado</label> <input type="submit" name="login" id="login" value="Login" />
		</fieldset>
	</form>

</body>
</html>