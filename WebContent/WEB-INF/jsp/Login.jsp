<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>

<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="css/formulario.css" />
<link rel="stylesheet" type="text/css" href="css/login.css" />
<title>${initParam.title}</title>

</head>

<body>

	<jsp:include page="Cabecalho.jsp" />

	<form action="efetuarLogon.do" method="post">

		<fieldset id="fieldset1">
			<div id="login">
				<label for="login">Login</label>
				<c:choose>
					<c:when test="${not empty requestScope.ERRO_ACESSO_NEGADO}">
						<input type="text" name="login" id="login"
							value="${requestScope.ERRO_ACESSO_NEGADO }"
							placeholder="Informe seu nome..." size="30" />
					</c:when>
					<c:otherwise>
						<input type="text" name="login" id="login"
							placeholder="Informe seu login..." size="30" />
					</c:otherwise>
				</c:choose>
			</div>
			<div>
				<label for="senha">Senha</label> <input type="password" id="senha"
					name="senha" size="30" placeholder="Informe sua senha..." />
			</div>
			<h1>
				<a href="requisitarSenha.do">Esqueceu sua senha ?</a>
			</h1>
			<fieldset id="fieldset2">
				<button type="submit">Login</button>
			</fieldset>
		</fieldset>
	</form>
	<jsp:include page="Rodape.jsp" />
</body>

</html>