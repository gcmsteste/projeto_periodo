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
	<jsp:include page="cabecalhoUsuarioLogado.jsp" />
	<form action="cadastroMonitoria.do" method="post">
		<fieldset>
			<label>Disciplinas</label> <select name="disciplina">
				<c:forEach var="disciplina"
					items="${requestScope['listaDisciplinas']}">
					<option><c:out value="${disciplina.descricao }" /></option>
				</c:forEach>
			</select> <label>Bolsista</label> <input type="radio" name="modalidade"
				id="bolsista" value="BOLSISTA" /> <label>Voluntário</label> <input
				type="radio" name="modalidade" id="voluntario" value="VOLUNTARIO" />
			<input type="submit" value="Realizar cadastro" />
		</fieldset>
	</form>


	<jsp:include page="rodape.jsp" />
</body>
</html>