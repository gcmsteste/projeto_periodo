<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Insert title here</title>
</head>
<body>
	<form action="cadastroMonitoria.do">
		<input type="submit" value="Cadastrar Monitoria" />
	</form>
	<p>
		<c:out value="${requestScope['monitoria'].disciplina.descricao }" />
		<c:out value=" ${requestScope['monitoria'].periodo }" />
	</p>
</body>
</html>