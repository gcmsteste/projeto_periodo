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
	<form action="formCadastroMonitoria">
		<input type="submit" value="Cadastrar Monitoria" />
	</form>
	<ul>
		<c:forEach var="monitor" items="${requestScope['listaMonitores']}">
			<li>
				<c:out value="${monitor.disciplina.descricao }" />
				<c:out value=" ${monitor.periodo }" />
			</li>
		</c:forEach>
	</ul>
</body>
</html>