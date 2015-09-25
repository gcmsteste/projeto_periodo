<%@page import="br.com.projetoperiodo.controller.acesso.ControladorAcesso"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ page import="br.com.projetoperiodo.model.usuario.Usuario" %>
</head>
<body>
	<% Usuario usuario = (Usuario)session.getAttribute(ControladorAcesso.USUARIO_LOGADO); %>
	<p> Bem vindo <%= usuario.getNome() %> </p>
</body>
</html>