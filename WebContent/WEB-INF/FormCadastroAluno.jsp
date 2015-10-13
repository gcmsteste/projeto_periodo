<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Insert title here</title>
</head>
<body>
	<form>
		<fieldset>
			<label id="nome">Nome</label>
			<input type="text" id="nome" name="nome" />
			<label id="sobrenome">Sobrenome</label>
			<input type="text" id="sobrenome" name="sobrenome" />
			<label id="matricula">Matricula</label>
			<input type="text" id="matricula" name="matricula" />
			<label id="email">E-mail</label>
			<input type="email" name="email" id="email" />
			<label id="disciplinas">Disciplinas</label>
			<select id="disciplinasdisponiveis">
				<c:forEach var="disciplina" items="${requestScope['listaDisciplinas']}">
					<option><c:out value="${disciplina.descricao }" /></option>
				</c:forEach>
			</select>
			<input type="button" />
			<input type="button" />
			<select id="disciplinacursadas">
				
			</select>
			<label id="senha">Senha</label>
			<input type="password" name="senha" id="senha" />
			<label id="confirmasenha">Confirme sua senha</label>
			<input type="password" name="confirmasenha" id="confirmasenha" />
			<input type="submit" value="Realizar cadastro" />
		</fieldset>
	</form>
</body>
</html>