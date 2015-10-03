<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="/css/login.css" />
<title>Insert title here</title>
</head>
<body>
	<form action="/">
		<fieldset>
			<label for="nome">Nome do usuario</label>
			<div>
				<input type="text" name="nome" id="nome"
					placeholder="Informe seu nome..." size="30" />
			</div>

			<label for="senha">Senha</label>
			<p>
				<a>Esqueceu sua senha ?</a>
			</p>
			<div>
				<input type="password" id="senha" name="senha" size="30"
					placeholde="Informe sua senha..." />
			</div>
		</fieldset>

		<fieldset>
			<input type="checkbox" name="opcao" id="opcao" /> <label for="opcao">Mantenha-me
				logado</label> <input type="submit" name="login" id="login" value="Login" />
		</fieldset>
	</form>
</body>
</html>