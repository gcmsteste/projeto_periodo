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
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<style>
a#botaoRelatorio {
	display: block;
	padding: 19px 39px 18px 39px;
	color: #FFF;
	background-color: #4bc970;
	font-size: 18px;
	text-align: center;
	font-style: normal;
	border-radius: 5px;
	width: 91%;
	border: 1px solid #3ac162;
	border-width: 1px 1px 3px;
	box-shadow: 0 -1px 0 rgba(255, 255, 255, 0.1) inset;
	margin-bottom: 10px;
	padding: 19px 39px 18px 39px;
}
fieldset {
	margin-bottom: 30px;
	border: none;
}

button {
	padding: 19px 39px 18px 39px;
	color: #FFF;
	background-color: #4bc970;
	font-size: 18px;
	text-align: center;
	font-style: normal;
	border-radius: 5px;
	width: 100%;
	border: 1px solid #3ac162;
	border-width: 1px 1px 3px;
	box-shadow: 0 -1px 0 rgba(255, 255, 255, 0.1) inset;
	margin-bottom: 10px;
}

</style>
<script type="text/javascript">
	$(function() {
		$("input[type=submit]").button().click(function(event) {

		});
	});
	$(function() {
		$(".datepicker").datepicker(
				{
					dateFormat : 'dd/mm/yy',
					dayNames : [ 'Domingo', 'Segunda', 'Terça', 'Quarta',
							'Quinta', 'Sexta', 'Sábado' ],
					dayNamesMin : [ 'D', 'S', 'T', 'Q', 'Q', 'S', 'S', 'D' ],
					dayNamesShort : [ 'Dom', 'Seg', 'Ter', 'Qua', 'Qui', 'Sex',
							'Sáb', 'Dom' ],
					monthNames : [ 'Janeiro', 'Fevereiro', 'Março', 'Abril',
							'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro',
							'Outubro', 'Novembro', 'Dezembro' ],
					monthNamesShort : [ 'Jan', 'Fev', 'Mar', 'Abr', 'Mai',
							'Jun', 'Jul', 'Ago', 'Set', 'Out', 'Nov', 'Dez' ],
					nextText : 'Próximo',
					prevText : 'Anterior'
				});
	});

	$(function() {
		$("#accordion").accordion({
			event : "click hoverintent"
		});
	});

	/*
	 * hoverIntent | Copyright 2011 Brian Cherne
	 * http://cherne.net/brian/resources/jquery.hoverIntent.html
	 * modified by the jQuery UI team
	 */
	$.event.special.hoverintent = {
		setup : function() {
			$(this).bind("mouseover", jQuery.event.special.hoverintent.handler);
		},
		teardown : function() {
			$(this).unbind("mouseover",
					jQuery.event.special.hoverintent.handler);
		},
		handler : function(event) {
			var currentX, currentY, timeout, args = arguments, target = $(event.target), previousX = event.pageX, previousY = event.pageY;

			function track(event) {
				currentX = event.pageX;
				currentY = event.pageY;
			}
			;

			function clear() {
				target.unbind("mousemove", track).unbind("mouseout", clear);
				clearTimeout(timeout);
			}

			function handler() {
				var prop, orig = event;

				if ((Math.abs(previousX - currentX) + Math.abs(previousY
						- currentY)) < 7) {
					clear();

					event = $.Event("hoverintent");
					for (prop in orig) {
						if (!(prop in event)) {
							event[prop] = orig[prop];
						}
					}
					// Prevent accessing the original event since the new event
					// is fired asynchronously and the old event is no longer
					// usable (#6028)
					delete event.originalEvent;

					target.trigger(event);
				} else {
					previousX = currentX;
					previousY = currentY;
					timeout = setTimeout(handler, 100);
				}
			}

			timeout = setTimeout(handler, 100);
			target.bind({
				mousemove : track,
				mouseout : clear
			});
		}
	};
</script>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="CabecalhoUsuarioLogado.jsp" />
	<form action="cadastroRelatorio.do" method="post">
		<div id="accordion">
			<h3>Primeira semana</h3>
			<div>

				<textarea rows="13" cols="30" name="descricaosemana1"><c:out value="${ sessionScope['relatorio'].semanas[0].descricao}" /></textarea>

				<label>Primeiro dia</label> <input type="text" class="datepicker"
					name="semana1atividade1"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${sessionScope['relatorio'].semanas[0].atividades[0].data}" />" />

				<label>Segundo dia</label> <input type="text" class="datepicker"
					name="semana1atividade2"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${sessionScope['relatorio'].semanas[0].atividades[1].data}" />" />

				<label>Terceiro dia</label> <input type="text" class="datepicker"
					name="semana1atividade3"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${sessionScope['relatorio'].semanas[0].atividades[2].data}" />" />

				<label>Quarto dia</label> <input type="text" class="datepicker"
					name="semana1atividade4"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${sessionScope['relatorio'].semanas[0].atividades[3].data}" />" />
				<label>Quinto dia</label> <input type="text" class="datepicker"
					name="semana1atividade5"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${sessionScope['relatorio'].semanas[0].atividades[4].data}" />" />

			</div>
			<h3>Segunda semana</h3>
			<div>

				<textarea rows="13" cols="30" name="descricaosemana2"><c:out value="${ sessionScope['relatorio'].semanas[1].descricao}" /></textarea>

				<label>Primeiro dia</label> <input type="text" class="datepicker"
					name="semana2atividade1"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${sessionScope['relatorio'].semanas[1].atividades[0].data}" />" />

				<label>Segundo dia</label> <input type="text" class="datepicker"
					name="semana2atividade2"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${sessionScope['relatorio'].semanas[1].atividades[1].data}" />" />

				<label>Terceiro dia</label> <input type="text" class="datepicker"
					name="semana2atividade3"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${sessionScope['relatorio'].semanas[1].atividades[2].data}" />" />

				<label>Quarto dia</label> <input type="text" class="datepicker"
					name="semana2atividade4"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${sessionScope['relatorio'].semanas[1].atividades[3].data}" />" />
				<label>Quinto dia</label> <input type="text" class="datepicker"
					name="semana2atividade5"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${sessionScope['relatorio'].semanas[1].atividades[4].data}" />" />

			</div>

			<h3>Terceira semana</h3>
			<div>

				<textarea rows="13" cols="30" name="descricaosemana3"><c:out value="${ sessionScope['relatorio'].semanas[2].descricao}" /></textarea>

				<label>Primeiro dia</label> <input type="text" class="datepicker"
					name="semana3atividade1"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${sessionScope['relatorio'].semanas[2].atividades[0].data}" />" />

				<label>Segundo dia</label> <input type="text" class="datepicker"
					name="semana3atividade2"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${sessionScope['relatorio'].semanas[2].atividades[1].data}" />" />

				<label>Terceiro dia</label> <input type="text" class="datepicker"
					name="semana3atividade3"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${sessionScope['relatorio'].semanas[2].atividades[2].data}" />" />

				<label>Quarto dia</label> <input type="text" class="datepicker"
					name="semana3atividade4"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${sessionScope['relatorio'].semanas[2].atividades[3].data}" />" />
				<label>Quinto dia</label> <input type="text" class="datepicker"
					name="semana3atividade5"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${sessionScope['relatorio'].semanas[2].atividades[4].data}" />" />

			</div>


			<h3>Quarta semana</h3>
			<div>

				<textarea rows="13" cols="30" name="descricaosemana4"><c:out value="${ sessionScope['relatorio'].semanas[3].descricao}" /></textarea>

				<label>Primeiro dia</label> <input type="text" class="datepicker"
					name="semana4atividade1"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${sessionScope['relatorio'].semanas[3].atividades[0].data}" />" />

				<label>Segundo dia</label> <input type="text" class="datepicker"
					name="semana4atividade2"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${sessionScope['relatorio'].semanas[3].atividades[1].data}" />" />

				<label>Terceiro dia</label> <input type="text" class="datepicker"
					name="semana4atividade3"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${sessionScope['relatorio'].semanas[3].atividades[2].data}" />" />

				<label>Quarto dia</label> <input type="text" class="datepicker"
					name="semana4atividade4"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${sessionScope['relatorio'].semanas[3].atividades[3].data}" />" />
				<label>Quinto dia</label> <input type="text" class="datepicker"
					name="semana4atividade5"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${sessionScope['relatorio'].semanas[3].atividades[4].data}" />" />

			</div>
			<h3>Quinta semana</h3>
			<div>

				<textarea rows="13" cols="30" name="descricaosemana5"><c:out value="${ sessionScope['relatorio'].semanas[4].descricao}" /></textarea>

				<label>Primeiro dia</label> <input type="text" class="datepicker"
					name="semana5atividade1"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${sessionScope['relatorio'].semanas[4].atividades[0].data}" />" />

				<label>Segundo dia</label> <input type="text" class="datepicker"
					name="semana5atividade2"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${sessionScope['relatorio'].semanas[4].atividades[1].data}" />" />

				<label>Terceiro dia</label> <input type="text" class="datepicker"
					name="semana5atividade3"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${sessionScope['relatorio'].semanas[4].atividades[2].data}" />" />

				<label>Quarto dia</label> <input type="text" class="datepicker"
					name="semana5atividade4"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${sessionScope['relatorio'].semanas[4].atividades[3].data}" />" />
				<label>Quinto dia</label> <input type="text" class="datepicker"
					name="semana5atividade5"
					value="<fmt:formatDate pattern="dd/MM/yyyy" value="${sessionScope['relatorio'].semanas[4].atividades[4].data}" />" />

			</div>
		</div>
		<fieldset id="fieldset2">
			<button type="submit">Salvar</button>
			<a href="gerarDocumento.do?mes=${sessionScope['relatorio'].mes }"
				id="botaoRelatorio">Gerar relatorio</a>
		</fieldset>

	</form>


</body>
</html>