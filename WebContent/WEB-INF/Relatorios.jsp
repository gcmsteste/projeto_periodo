<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="js/jquery-ui-1.11.4/external/jquery/jquery.js"></script>
<script src="js/jquery-ui-1.11.4/jquery-ui.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
@import
	url(http://fonts.googleapis.com/css?family=Roboto:400,500,700,300,100);

body {
	font-family: "Roboto", helvetica, arial, sans-serif;
	font-size: 16px;
	font-weight: 400;
	text-rendering: optimizeLegibility;
}

div.table-title {
	display: block;
	margin: auto;
	max-width: 600px;
	padding: 5px;
	width: 100%;
}

.table-title h3 {
	color: #fafafa;
	font-size: 30px;
	font-weight: 400;
	font-style: normal;
	font-family: "Roboto", helvetica, arial, sans-serif;
	text-shadow: -1px -1px 1px rgba(0, 0, 0, 0.1);
	text-transform: uppercase;
}

/*** Table Styles **/
.table-fill {
	background: white;
	border-radius: 3px;
	border-collapse: collapse;
	height: 320px;
	margin: 2px 20px;
	max-width: 600px;
	padding: 5px;
	width: 100%;
	box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
	animation: float 5s infinite;
}

th {
	color: #D5DDE5;;
	background: #1b1e24;
	border-bottom: 4px solid #9ea7af;
	border-right: 1px solid #343a45;
	font-size: 23px;
	font-weight: 100;
	padding: 24px;
	text-align: left;
	text-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
	vertical-align: middle;
}

th:first-child {
	border-top-left-radius: 3px;
}

th:last-child {
	border-top-right-radius: 3px;
	border-right: none;
}

tr {
	border-top: 1px solid #C1C3D1;
	border-bottom-: 1px solid #C1C3D1;
	color: #666B85;
	font-size: 16px;
	font-weight: normal;
	text-shadow: 0 1px 1px rgba(256, 256, 256, 0.1);
}

a {
	color: #fafafa;
	font-size: 60px;
	font-weight: 400;
	font-style: normal;
	font-family: "Roboto", helvetica, arial, sans-serif;
	text-shadow: -1px -1px 1px rgba(0, 0, 0, 0.1);
	text-transform: uppercase;
}

td:hover {
	background: #4E5066;
	color: #FFFFFF;
	border-top: 1px solid #22262e;
	border-bottom: 1px solid #22262e;
}

tr:first-child {
	border-top: none;
}

tr:last-child {
	border-bottom: none;
}

td:nth-child(odd) {
	background: #EBEBEB;
}

td:nth-child(odd):hover {
	background: #4E5066;
}

tr:last-child td:first-child {
	border-bottom-left-radius: 3px;
}

tr:last-child td:last-child {
	border-bottom-right-radius: 3px;
}

td {
	background: #FFFFFF;
	padding: 20px;
	text-align: left;
	vertical-align: middle;
	font-weight: 300;
	font-size: 18px;
	text-shadow: -1px -1px 1px rgba(0, 0, 0, 0.1);
	border-right: 1px solid #C1C3D1;
}

td:last-child {
	border-right: 0px;
}

th.text-left {
	text-align: left;
}

th.text-center {
	text-align: center;
}

th.text-right {
	text-align: right;
}

td.text-left {
	text-align: left;
}

td.text-center {
	text-align: center;
}

td.text-right {
	text-align: right;
}
</style>

<title>Monitoria IFPE-TADS</title>
</head>
<body>

	<jsp:include page="CabecalhoUsuarioLogado.jsp" />


	<table class="table-fill">

		<tbody class="table-hover">
			<tr>
				<td class="text-left"><a href="cadastroRelatorio.do?mes=1">Janeiro</a></td>
				<td class="text-left"><a href="cadastroRelatorio.do?mes=7">Julho</a></td>
			</tr>
			<tr>
				<td class="text-left"><a href="cadastroRelatorio.do?mes=2">Fevereiro</a></td>
				<td class="text-left"><a href="cadastroRelatorio.do?mes=8">Agosto</a></td>
			</tr>
			<tr>
				<td class="text-left"><a href="cadastroRelatorio.do?mes=3">Março</a></td>
				<td class="text-left"><a href="cadastroRelatorio.do?mes=9">Setembro</a></td>
			</tr>
			<tr>
				<td class="text-left"><a href="cadastroRelatorio.do?mes=4">Abril</a></td>
				<td class="text-left"><a href="cadastroRelatorio.do?mes=10">Outubro</a></td>
			</tr>
			<tr>
				<td class="text-left"><a href="cadastroRelatorio.do?mes=5">Maio</a></td>
				<td class="text-left"><a href="cadastroRelatorio.do?mes=11">Novembro</a></td>
			</tr>
			<tr>
				<td class="text-left"><a href="cadastroRelatorio.do?mes=6">Junho</a></td>
				<td class="text-left"><a href="cadastroRelatorio.do?mes=12">Dezembro</a></td>
			</tr>
		</tbody>
	</table>


	<jsp:include page="Rodape.jsp" />
</body>
</html>