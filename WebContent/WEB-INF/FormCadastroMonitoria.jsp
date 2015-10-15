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
	<form action="cadastroMonitoria.do" method="post">
		<fieldset>
			<label id="disciplinas">Disciplinas</label>
			<select id="disciplinas">
				<c:forEach var="disciplina" items="${requestScope['listaDisciplinas']}">
					<option><c:out value="${disciplina.descricao }" /></option>
				</c:forEach>
			</select>
			<label id="bolsista">Bolsista</label>
			<input type="radio" name="modalidade" id="bolsista" />
			<label id="voluntario">Voluntário</label>
			<input type="radio" name="modalidade" id="voluntario" />
			<input type="submit" value="Realizar cadastro" />
		</fieldset>
	</form>
</body>
</html>