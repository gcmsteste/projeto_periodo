<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="js/jquery-ui-1.11.4/jquery-ui.css">
<script src="js/jquery-ui-1.11.4/external/jquery/jquery.js"></script>
<script src="js/jquery-ui-1.11.4/jquery-ui.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
	$(function() {

		$("#select").button({

			text : false,

		})

		.click(function() {

			var menu = $(this).parent().next().show().position({

				my : "left top",

				at : "left bottom",

				of : this

			}).click(function() {
				
			});
			$(document).one("click", function() {

				menu.hide();

			});

			return false;

		})

		.parent()

		.buttonset()

		.next()

		.hide()

		.menu();

	});
</script>
<title>Insert title here</title>
</head>
<body>
	<div>
		<button id="select">Janeiro</button>
	</div>
	<ul>
		<li><a href="gerarDocumento.do?mes=1">Gerar documento</a></li>
	</ul>


	<table>
		<tr>
			<td><button>Janeiro</button></td>
			<td><a href="cadastroRelatorio.do?mes=2">Fevereiro</a></td>
			<td><a href="cadastroRelatorio.do?mes=3">Março</a></td>
			<td><a href="cadastroRelatorio.do?mes=4">Abril</a></td>
			<td><a href="cadastroRelatorio.do?mes=5">Maio</a></td>
			<td><a href="cadastroRelatorio.do?mes=6">Junho</a></td>

		</tr>
		<tr>
			<td><a href="cadastroRelatorio.do?mes=7">Julho</a></td>
			<td><a href="cadastroRelatorio.do?mes=8">Agosto</a></td>
			<td><a href="cadastroRelatorio.do?mes=9">Setembro</a></td>
			<td><a href="cadastroRelatorio.do?mes=10">Outubro</a></td>
			<td><a href="cadastroRelatorio.do?mes=11">Novembro</a></td>
			<td><a href="cadastroRelatorio.do?mes=12">Dezembro</a></td>
		</tr>
	</table>
</body>
</html>