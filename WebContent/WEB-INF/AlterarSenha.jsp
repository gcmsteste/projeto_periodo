<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jslt/core %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="css/formulario.css">
<script type="text/javascript" src="alterarSenha.js"></script>
<title>Monitoria IFPE-TADS</title>
</head>
<body>
	<jsp:include page="Cabecalho.jsp" />
	<form action="Servlet_alterarSenha.do" method="post">
		<fieldset id="fieldset1">
		<c:choose>
		
			<c:when test='${empty param.login1}'>
			
				<p>[Login ou e-mail incorretos, tente novamente]</p>
				
			</c:when>
			
			<c:when test='$[param.senhaAntiga == senhaNova]'>
			
				<p>[Você não pode utilizar a mesma senha ao alterá-la]</p>
				
			</c:when>
			
			<c:otherwise>
			
				<p>[Preencha o campo com o seu login ou e-mail para que sua senha possa ser alterada]</p>
				
			</c:otherwise>
			
		</c:choose>
			<label for="login1">Login ou E-mail</label>
			 <input type="text" id="login1"/>

			<fieldset id="fieldset2">
			<label for="senhaAntiga">Senha Antiga</label>
				<input type="text" id="senhaAntiga"/>
				
				<label for="senhaNova">Senha Nova</label>
				<input type="text" id="esnhaNova"/>
			</fieldset>
			<fieldset id="fieldset3">
				<button type="submit">Alterar Senha</button>
			</fieldset>

		</fieldset>
	</form>
	<jsp:include page="Rodape.jsp" />
</body>
</html>