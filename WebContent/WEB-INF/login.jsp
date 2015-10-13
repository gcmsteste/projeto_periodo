<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" session="false"%>

<!DOCTYPE html>

<html>

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<link href="jquery-ui.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="menu.css" media="screen"/>
	<link rel="stylesheet" type="text/css" href="rodape.css" media="screen"/>
	<link rel="stylesheet" type="text/css" href="form.css" media="screen"/>
	<script src="js/jquery.js"></script>
	<script src="js/jquery-ui.js"></script>
	<!--  <script src="js/jquery-ui-1.11.4.custom/jquery-ui.js"></script> -->
	
	<script>
     </script>
        
	<title>Insert title here</title>

</head>

<body>
	
	<table id="menu">
        
			<tr>
			
            	<td><a href="" id="linke">Login</a></td>
                <td><a href="login.do" id="linkc">Entrar</a></td>
               	<td><a href="" id="linkd">Cadastro</a></td>
                <td><a href="Professor.jsp" id="linka">Professor</a></td>
                <td><a href="cadastroAluno.do" id="linkb">Aluno</a></td>
                        
            </tr>
                        
        </table>
    
    <form action="efetuarLogon.do" method="post">
		
		<fieldset id="fieldset1">
        	
        	<div id="login">
        	
				<label for="login">Nome do usuário</label>
					
					<c:choose>
					
						<c:when test="${not empty requestScope.ERRO_ACESSO_NEGADO}">
						<input type="text" name="login" id="login" value="${requestScope.ERRO_ACESSO_NEGADO }" placeholder="Informe seu nome..." size="30" />
						
					</c:when>
					
						<c:otherwise>
							
							<input type="text" name="login" id="login" placeholder="Informe seu nome..." size="30" />
							
						</c:otherwise>
						
					</c:choose>
				
			 </div>

			<div>
				
				<label for="senha">Senha</label>
                <input type="password" id="senha" name="senha" size="30" placeholder="Informe sua senha..." />
                
			</div>
                    
			<p>
            	
            	<a href="" id="linksenha">Esqueceu sua senha ?</a>
            	
			</p>    
            
            <fieldset id="fieldset2">
            
            	<input type="checkbox" name="opcao" id="opcao" /> 
                <label for="opcao">Mantenha-me logado</label> 
                <input type="submit" name="login" id="login" value="Login" />
                                
             </fieldset>
                        
		</fieldset>
            
	</form>
		
		<table id="rodape">
             
             <tr>
                 
                <td> <img src="logo-tads2.png" alt="logo do tads"/> </td>
                <td> <img src="ifpe.jpg" id="ifpe" alt="logo do ifpe"/> </td>
                
            </tr>
            
         </table>

</body>

</html>