<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/formulario.css" />
<title>${initParam.title}</title>
<style>
p {
	display: inline-block;
}

.estrategia p+input+p, .estrategia p+input+p+input  {
	position: relative;
	left: 30px;
}
</style>
</head>
<body>
	<jsp:include page="Cabecalho.jsp" />
	<form action="configuracoes.do" method="post">

		<fieldset id="fieldset1">
			<div class="banco">
				<label>Banco</label>
				<p>Oracle</p>
				<input type="radio" name="banco" value="ORACLE_LOCAL_UNIT" />
				<p>MySQL</p>
				<input type="radio" name="banco" value="MYSQL_LOCAL_UNIT" />
			</div>
			<div class="estrategia">
				<label>Estratégia</label>
				<p>JPA</p>
				<input type="radio" name="estrategia" value="FABRICA_JPA" />
				<p>JDBC</p>
				<input type="radio" name="estrategia" value="FABRICA_JDBC" />
			</div>

			<fieldset id="fieldset2">
				<button type="submit">Configurar</button>
			</fieldset>
		</fieldset>
	</form>
	<jsp:include page="Rodape.jsp" />
</body>
</html>