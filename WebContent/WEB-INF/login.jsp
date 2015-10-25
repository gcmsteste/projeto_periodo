<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>

<!DOCTYPE html>

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="css/login.css" />


<title>Insert title here</title>
<script type="application/x-javascript">
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 


</script>
</head>

<body>
	<jsp:include page="cabecalho.jsp" />
	<div class="container">

		<div id="login-form">

			<h3>Login</h3>

			<fieldset>

				<form action="efetuarLogon.do" method="post">

					<input type="text" required value="Email"
						onBlur="if(this.value=='')this.value='Email'"
						onFocus="if(this.value=='Email')this.value='' " name="login">
					<!-- JS because of IE support; better: placeholder="Email" -->

					<input type="password" required value="Password"
						onBlur="if(this.value=='')this.value='Password'"
						onFocus="if(this.value=='Password')this.value='' " name="senha">
					<!-- JS because of IE support; better: placeholder="Password" -->

					<input type="submit" value="Login">

					<footer class="clearfix">

						<p>
							<span class="info">?</span><a href="#">Forgot Password</a>
						</p>

					</footer>

				</form>

			</fieldset>

		</div>
		<!-- end login-form -->

	</div>
	<jsp:include page="rodape.jsp" />
</body>

</html>