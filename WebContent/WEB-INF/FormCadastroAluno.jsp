<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" href="css/menu_disciplina.css" type="text/css"
	media="screen">
<script type="text/javascript">
	$()
			.ready(
					function() {
						$('#add')
								.click(
										function() {
											return !$(
													'#disciplinas option:selected')
													.remove()
													.appendTo(
															'#disciplinas_selecionadas');
										});
						$('#remove')
								.click(
										function() {
											return !$(
													'#disciplinas_selecionadas option:selected')
													.remove().appendTo(
															'#disciplinas');
										});
					});
	$()
			.ready(
					function() {
						$('#add')
								.click(
										function() {
											return !$(
													'#disciplinas option:selected')
													.remove()
													.appendTo(
															'#disciplinas_selecionadas');
										});
						$('#remove')
								.click(
										function() {
											return !$(
													'#disciplinas_selecionadas option:selected')
													.remove().appendTo(
															'#disciplinas');
										});
					});
</script>

<script>
	$('form').submit(function() {
		$('#disciplinas_selecionadas option').each(function(i) {
			$(this).attr("selected", "selected");
		});
	});
</script>

<title>Insert title here</title>

</head>
<body>
	<form action="cadastroAluno.do" method="post">
		<fieldset>
			<label id="nome">Nome</label> <input type="text" id="nome"
				name="nome" /> <label id="sobrenome">Sobrenome</label> <input
				type="text" id="sobrenome" name="sobrenome" /> <label
				id="matricula">Matricula</label> <input type="text" id="matricula"
				name="matricula" /> <label id="email">E-mail</label> <input
				type="email" name="email" id="email" />
			<div>

				<select multiple id="disciplinas" name ="disciplinas">

					<!--  <option value="1">Option 1</option>  
				   <option value="2">Option 2</option>  
				   <option value="3">Option 3</option>  
				   <option value="4">Option 4</option> -->

					<c:forEach var="disciplina"	items="${requestScope['listaDisciplinas']}">
						<option ><c:out  value="${disciplina.descricao }" /></option>
					</c:forEach>

				</select> <a href="#" id="add">add</a>

			</div>

			<div>

				<select multiple id="disciplinas_selecionadas"></select> <a href="#"
					id="remove"> remove</a>

			</div>
			<label id="senha">Senha</label> <input type="password" name="senha"
				id="senha" /> <label id="confirmasenha">Confirme sua senha</label>
			<input type="password" name="confirmasenha" id="confirmasenha" /> <input
				type="submit" value="Realizar cadastro" />
		</fieldset>
	</form>
	
	
</body>
</html>