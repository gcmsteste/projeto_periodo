<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Insert title here</title>
<script>

</script>
</head>
<body>
	<form action="cadastroMonitoria.do">
		<input type="submit" value="Cadastrar Monitoria" />
	</form>
	<table>
		<tr>
			<th>Descrição</th>
			<th>Período</th>
			<th>Modalidade</th>
		</tr>
		<c:forEach var="monitoria" items="${requestScope['listaMonitorias']}">
			<tr>
				<td><a
					href="relatorio.do?chaveMonitor=${monitoria.chavePrimaria}"> <c:out
							value="${monitoria.disciplina.descricao }" />
				</a></td>
				<td><c:out value=" ${monitoria.periodo }" /></td>
				<td><c:out value=" ${monitoria.modalidade }" /></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>