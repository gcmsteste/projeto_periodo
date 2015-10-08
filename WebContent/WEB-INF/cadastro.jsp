<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="menu.css" media="screen"/>
<title>Sistema Monitoria - Cadastro</title>
</head>
<body>
	<table id="menu">
			<tr>
                            <td>Login</td>
                            <td><a href="login.do" id="linkc">Entrar</a></td>
                            <td>Cadastro
                            <td><a href="" id="linka">Professor</a></td>
                            <td><a href="" id="linkb">Aluno</a></td>
                        </tr>	
        </table>
        
	<form action="" method="post">
		<fieldset>
			<label id="nome">Nome</label>
			<input type="text" id="nome" name="nome" placeholder="Informe seu nome..." />
			<label id="sobrenome">Sobrenome</label>
			<input type="text" id="sobrenome" name="sobrenome" placeholder="Informe seu sobrenome..." />
			<label id="matricula">Matr�cula</label>
			<input type="text" name="matricula" id="matricula" placeholder="Informe sua matr�cula..." />
			<label id="email">E-mail</label>
			<input type="email" name="email" id="email" placeholder="Informe seu e-mail..." />
			<label id="password">Senha</label>
			<input type="password" id="password" name="password" placeholder="Informe a sua senha..." />
			<label id="passconfirma">Confirmar senha</label>
			<input type="password" id="passconfirma" name="passconfirma" />
			<input type="submit" value="Cadastrar" />
		</fieldset>
	</form>
</body>
</html>