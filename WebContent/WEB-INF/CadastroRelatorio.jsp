<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="js/jquery-ui-1.11.4/jquery-ui.css">
<link rel="stylesheet" href="css/cadastro-relatorio.css">
<script src="js/jquery-ui-1.11.4/external/jquery/jquery.js"></script>
<script src="js/jquery-ui-1.11.4/jquery-ui.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	$(function() {
		$(".datepicker").datepicker();
	});
	$(function() {
		$("#accordion").accordion();
	});
</script>
<title>Insert title here</title>
</head>
<body>
	<form action="cadastroRelatorio.do" method="post">
		<div id="accordion">
			<h3>Primeira semana</h3>
			<div>

				<textarea rows="13" cols="30" name="descricaosemana1">
					<c:out value="${ requestScope['relatorio'].semanas[0].descricao}" />
				</textarea>
				
				<label>Primeiro dia</label> 
				<input type="text" class="datepicker" name="semana1atividade1" 
				value="${ sessionScope['relatorio'].semanas[0].atividade[0].data }" /> 
				
				<label>Segundo dia</label> 
				<input type="text" class="datepicker" name="semana1atividade2" 
					value="${ sessionScope['relatorio'].semanas[0].atividade[1].data }" />
				
				 <label>Terceiro dia</label> 
				 <input type="text" class="datepicker" name="semana1atividade3"
				 	value="${ sessionScope['relatorio'].semanas[0].atividade[2].data }" />
				 
				 <label>Quarto dia</label> 
				 <input type="text" class="datepicker" name="semana1atividade4"
				 	value="${ sessionScope['relatorio'].semanas[0].atividade[3].data }" /> 
				 <label>Quinto dia</label> 
				 <input type="text" class="datepicker" name="semana1atividade5"
				 	value="${ sessionScope['relatorio'].semanas[0].atividade[4].data }" />

			</div>
			<h3>Segunda semana</h3>
			<div>

				<textarea rows="13" cols="30" name="descricaosemana2"></textarea>
				<label>Primeiro dia</label> <input type="text" class="datepicker"
					name="semana2atividade1" /> <label>Segundo dia</label> <input
					type="text" class="datepicker" name="semana2atividade2" /> <label>Terceiro
					dia</label> <input type="text" class="datepicker" name="semana2atividade3" />
				<label>Quarto dia</label> <input type="text" class="datepicker"
					name="semana2atividade4" /> <label>Quinto dia</label> <input
					type="text" class="datepicker" name="semana2atividade5" />

			</div>

			<h3>Terceira semana</h3>
			<div>

				<textarea rows="13" cols="30" name="descricaosemana3"></textarea>
				<label>Primeiro dia</label> <input type="text" class="datepicker"
					name="semana3atividade1" /> <label>Segundo dia</label> <input
					type="text" class="datepicker" name="semana3atividade2" /> <label>Terceiro
					dia</label> <input type="text" class="datepicker" name="semana3atividade3" />
				<label>Quarto dia</label> <input type="text" class="datepicker"
					name="semana3atividade4" /> <label>Quinto dia</label> <input
					type="text" class="datepicker" name="semana3tividade5" />

			</div>

		
			<h3>Quarta semana</h3>
			<div>

				<textarea rows="13" cols="30" name="descricaosemana4"></textarea>
				<label>Primeiro dia</label> <input type="text" class="datepicker"
					name="semana3atividade1" /> <label>Segundo dia</label> <input
					type="text" class="datepicker" name="semana4atividade2" /> <label>Terceiro
					dia</label> <input type="text" class="datepicker" name="semana4atividade3" />
				<label>Quarto dia</label> <input type="text" class="datepicker"
					name="semana4atividade4" /> <label>Quinto dia</label> <input
					type="text" class="datepicker" name="semana4atividade5" />

			</div>
			<h3>Quinta semana</h3>
			<div>

				<textarea rows="13" cols="30" name="descricaosemana5"></textarea>
				<label>Primeiro dia</label> <input type="text" class="datepicker"
					name="semana5atividade1" /> <label>Segundo dia</label> <input
					type="text" class="datepicker" name="semana5atividade2" /> <label>Terceiro
					dia</label> <input type="text" class="datepicker" name="semana5atividade3" />
				<label>Quarto dia</label> <input type="text" class="datepicker"
					name="semana5atividade4" /> <label>Quinto dia</label> <input
					type="text" class="datepicker" name="semana5atividade5" />

			</div>
		</div>
		<input type="submit" value="Save" />
	</form>


</body>
</html>