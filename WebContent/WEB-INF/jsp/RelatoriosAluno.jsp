<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/relatorios.css" />
<script src="js/jquery-ui-1.11.4/external/jquery/jquery.js"></script>
<script src="js/jquery-ui-1.11.4/jquery-ui.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<title>${initParam.title}</title>
</head>
<body>

	<jsp:include page="CabecalhoUsuarioLogado.jsp" />


	<table class="table-fill">
		<thead>
			<tr>
				<th colspan="3">Relatórios Mensais</th>
			</tr>
		</thead>
		<tbody class="table-hover">
			<c:choose>
				<c:when
					test="${sessionScope['monitoria'].periodo.semestre == 'PRIMEIRO' }">

					<tr>
						<td class="text-left"><a href="cadastroRelatorio.do?mes=1">Janeiro</a></td>
					</tr>
					<tr>
						<td class="text-left"><a href="cadastroRelatorio.do?mes=2">Fevereiro</a></td>
					</tr>
					<tr>
						<td class="text-left"><a href="cadastroRelatorio.do?mes=3">Março</a></td>
					</tr>
					<tr>
						<td class="text-left"><a href="cadastroRelatorio.do?mes=4">Abril</a></td>
					</tr>
					<tr>
						<td class="text-left"><a href="cadastroRelatorio.do?mes=5">Maio</a></td>
					</tr>
					<tr>
						<td class="text-left"><a href="cadastroRelatorio.do?mes=6">Junho</a></td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td class="text-left"><a href="cadastroRelatorio.do?mes=7">Julho</a></td>
					</tr>
					<tr>
						<td class="text-left"><a href="cadastroRelatorio.do?mes=8">Agosto</a></td>
					</tr>
					<tr>
						<td class="text-left"><a href="cadastroRelatorio.do?mes=9">Setembro</a></td>
					</tr>
					<tr>
						<td class="text-left"><a href="cadastroRelatorio.do?mes=10">Outubro</a></td>
					</tr>
					<tr>
						<td class="text-left"><a href="cadastroRelatorio.do?mes=11">Novembro</a></td>
					</tr>
					<tr>
						<td class="text-left"><a href="cadastroRelatorio.do?mes=12">Dezembro</a></td>
					</tr>
				</c:otherwise>
			</c:choose>

		</tbody>
	</table>


	<jsp:include page="RodapeUsuarioLogado.jsp" />
</body>
</html>