<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="images/favicon.gif" />
<link rel="stylesheet" type="text/css" href="css/cabecalho.css" />
<script type="text/javascript" src="js/cabecalho.js"></script>
<script type="text/javascript">
	var flashvars = {};
	flashvars.xml = "config.xml";
	flashvars.font = "font.swf";
	var attributes = {};
	attributes.wmode = "transparent";
	attributes.id = "slider";
	swfobject.embedSWF("cu3er.swf", "cu3er-container", "960", "270", "9",
			"expressInstall.swf", flashvars, attributes);
</script>
<title>Monitoria</title>
</head>
<body>
	<!--Header Begin-->
	<div id="header">
		<div class="center">
			<div id="logo">
				<a href="#">Monitoria IFPE-TADS</a>
			</div>
			<!--Menu Begin-->
			<div id="menu">
				<ul>
					<li><a class="active" href="index.html"><span>Home</span></a></li>
					<li><a href="about.html"><span>Aluno</span></a></li>
					<li><a href="#"><span>Professor</span></a></li>
					<li><a href="#"><span>Cadastro</span></a></li>
					<li><a href="#"><span>Recuperar Senha</span></a></li>
				</ul>
			</div>
			<!--Menu END-->
		</div>
	</div>
</body>
</html>