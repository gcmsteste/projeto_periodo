<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="css/formulario.css" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>${initParam.title}</title>
</head>
<body>
	<jsp:include page="CabecalhoUsuarioLogado.jsp" />


	<form action="alterarSenha.do" method="post">
		<fieldset id="fieldset1">

			<fieldset id="fieldset2">

				<label for="senhaAntiga"></label> Senha Antiga <input
					type="password" id="senhaAntiga" name="senhaAntiga" /> <label
					for="senhaNova"></label> Senha Nova <input type="password"
					id="senhaNova" name="senhaNova" />
			</fieldset>
			<fieldset id="fieldset3">
				<button type="submit">Alterar Senha</button>
			</fieldset>


		</fieldset>
	</form>
	<jsp:include page="Rodape.jsp" />
</body>
</html>