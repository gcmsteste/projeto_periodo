<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/tabela.css" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Monitoria IFPE-TADS</title>
</head>
<body>

	<jsp:include page="CabecalhoUsuarioLogado.jsp" />

	<table>
		<tr>
			<th>Aluno</th>
			<th>Disciplina</th>
			<th>Período</th>
			<th>Modalidade</th>

		</tr>
		<c:forEach var="monitoria"
			items="${requestScope['listaMonitoriasDisciplina']}">
			<tr>
				<td><a
					href="relatorioProfessor.do?chaveMonitor=${monitoria.chavePrimaria}"> <c:out
							value="${monitoria.aluno.nome }" /></a></td>
				<td><a
					href="relatorioProfessor.do?chaveMonitor=${monitoria.chavePrimaria}"> <c:out
							value="${monitoria.disciplina.descricao }" />
				</a></td>
				<td><a
					href="relatorioProfessor.do?chaveMonitor=${monitoria.chavePrimaria}"> <c:out
							value=" ${monitoria.periodo }" /></a></td>
				<td><a
					href="relatorioProfessor.do?chaveMonitor=${monitoria.chavePrimaria}"> <c:out
							value=" ${monitoria.modalidade }" /></a></td>

			</tr>
		</c:forEach>
	</table>

	<jsp:include page="Rodape.jsp" />
</body>
</html>