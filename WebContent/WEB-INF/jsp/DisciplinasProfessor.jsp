<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/tabela.css" />
<link rel="stylesheet" type="text/css" href="css/tabela_botoes.css" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>${initParam.title}</title>
</head>
<body>
	<jsp:include page="CabecalhoProfessorLogado.jsp" />
	<table>
		<tr>
			<th>Disciplina</th>
			<th><a href="cadastroDisciplina.do"></a></th>
		</tr>
		<c:forEach var="disciplina" items="${requestScope['disciplinasProfessor']}">
			<tr>
				<td><a
					href="disciplina.do?chaveDisciplina=${disciplina.chavePrimaria}"> <c:out
							value="${disciplina.descricao }" />
				</a></td>
				<td><a
					href="removeDisciplinaProfessor.do?chaveDisciplina=${disciplina.chavePrimaria}"></a></td> 
			</tr>
		</c:forEach>
	</table>
	<jsp:include page="RodapeUsuarioLogado.jsp" />
</body>
</html>