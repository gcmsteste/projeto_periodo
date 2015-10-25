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
<style>
ul {
	width: 330px;
}
</style>
<script>
	$(function() {
		$(".rerun").button().click(function() {

		}).next().button({
			text : false,
			icons : {
				primary : "ui-icon-triangle-1-s"
			}
		}).click(function() {
			var menu = $(this).parent().next().show().position({
				my : "left top",
				at : "left bottom",
				of : this,
				collision: "fit"
			});
			$(document).one("click", function() {
				menu.hide();
			});
			return false;
		}).parent().buttonset().next().hide().menu();
	});
</script>
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="cabecalhoUsuarioLogado.jsp" />
	<table>

		<tr>
			<td><a class="rerun" href="cadastroRelatorio.do?mes=1">Janeiro</a>
				<a class="select">Select an action</a></td>
			<td><a href="gerarDocumento.do?mes=1">Gerar Documento</a></td>
		
			<td><a class="rerun" href="cadastroRelatorio.do?mes=2">Fevereiro</a>
				<a class="select">Select an action</a></td>
			<td><a href="gerarDocumento.do?mes=2">Gerar Documento</a></td>

			<td><a class="rerun" href="cadastroRelatorio.do?mes=3">Março</a>
				<a class="select">Select an action</a></td>
			<td><a href="gerarDocumento.do?mes=3">Gerar Documento</a></td>
			
			<td><a class="rerun" href="cadastroRelatorio.do?mes=4">Abril</a>
				<a class="select">Select an action</a></td>
			<td><a href="gerarDocumento.do?mes=4">Gerar Documento</a></td>
			
			<td><a class="rerun" href="cadastroRelatorio.do?mes=5">Maio</a>
				<a class="select">Select an action</a></td>
			<td><a href="gerarDocumento.do?mes=5">Gerar Documento</a></td>
			
			<td><a class="rerun" href="cadastroRelatorio.do?mes=6">Junho</a>
				<a class="select">Select an action</a></td>
			<td><a href="gerarDocumento.do?mes=6">Gerar Documento</a></td>
		</tr>
		<tr>
			<td><a class="rerun" href="cadastroRelatorio.do?mes=7">julho</a>
				<a class="select">Select an action</a></td>
			<td><a href="gerarDocumento.do?mes=7">Gerar Documento</a></td>
		
			<td><a class="rerun" href="cadastroRelatorio.do?mes=8">Agosto</a>
				<a class="select">Select an action</a></td>
			<td><a href="gerarDocumento.do?mes=8">Gerar Documento</a></td>

			<td><a class="rerun" href="cadastroRelatorio.do?mes=9">Setembro</a>
				<a class="select">Select an action</a></td>
			<td><a href="gerarDocumento.do?mes=9">Gerar Documento</a></td>
			
			<td><a class="rerun" href="cadastroRelatorio.do?mes=10">Outubro</a>
				<a class="select">Select an action</a></td>
			<td><a href="gerarDocumento.do?mes=10">Gerar Documento</a></td>
			
			<td><a class="rerun" href="cadastroRelatorio.do?mes=11">Novembro</a>
				<a class="select">Select an action</a></td>
			<td><a href="gerarDocumento.do?mes=11">Gerar Documento</a></td>
			
			<td><a class="rerun" href="cadastroRelatorio.do?mes=12">Dezembro</a>
				<a class="select">Select an action</a></td>
			<td><a href="gerarDocumento.do?mes=12">Gerar Documento</a></td>
		</tr>
	</table>
	<jsp:include page="rodape.jsp" />
</body>
</html>