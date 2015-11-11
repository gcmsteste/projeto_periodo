<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="css/formulario.css">
<title>Monitoria IFPE-TADS</title>
</head>
<body>
	<jsp:include page="Cabecalho.jsp" />
	<form action="alterarSenha.do" method="post">
		<fieldset id="fieldset1">
			<label for="login1">Login</label>
			 <input type="text" />

			<fieldset id="fieldset2">
				<button type="submit">Alterar Senha</button>
			</fieldset>

		</fieldset>
	</form>
	<jsp:include page="Rodape.jsp" />
</body>
</html>