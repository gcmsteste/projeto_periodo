<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/tabela.css" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>${initParam.title}</title>
</head>
<body>
	<jsp:include page="CabecalhoUsuarioLogado.jsp" />
	
	<table>
		<tr>
			<th>Nome</th>
			<th>Sobrenome</th>
			<th>Email</th>
			<th>Matricula</th>
		</tr>
		<tr>
			<th>${requestScope['aluno'].getNome()}</th>
			<th>${requestScope['aluno'].getSobrenome()}</th>
			<th>${requestScope['aluno'].getEmail()}</th>
			<th>${requestScope['aluno'].getEmail()}</th>
		</tr>
		
	</table>
	
</body>
</html>