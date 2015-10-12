<%@ page language="java" contentType="text/html; charset=ISO-8859-1"pageEncoding="ISO-8859-1"%> 

<!DOCTYPE html>

<html>

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link href="css/jquery-ui.css" rel="stylesheet">
	<link href="css/jquery-ui.min.css" rel="stylesheet">
	<link href="css/jquery-ui.theme.css" rel="stylesheet">
	<link href="css/jquery-ui.theme.min.css" rel="stylesheet">
	<link href="css/jquery-ui.structure.css" rel="stylesheet">
	<link href="css/jquery-ui.structure.min.css" rel="stylesheet">
	<link href="css/principal.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="menu.css" media="screen"/>
	<script src="js/jquery.js"></script>
	<script src="js/jquery-ui.js"></script>
	
	<script> //evento links
        
            $(document).ready(function()
            {
                $("[href]").css("color","white");
                    $("#linka").mouseover(function() 
                    {
                        
                        $("#linka").css("color","deeppink");
                        
                    });
                    
                    $("#linkb").mouseover(function() 
                    {
                        
                        $("#linkb").css("color","deeppink");
                        
                    });
                    
                    $("#linkc").mouseover(function() 
                    {
                        
                        $("#linkc").css("color","deeppink");
                        
                    });
                    
                    $("#linkd").mouseover(function() 
                    {
                        
                        $("#linkd").css("color","deeppink");
                        
                    });
                    
                    $("#linke").mouseover(function() 
                    {
                        
                        $("#linke").css("color","deeppink");
                        
                    });
                    
                    
                    $("[href]").mouseout(function()
                    {
                        
                        $("[href]").css("color","white");
                                
                    });
                    
                    
            });
            
        </script>
	
	<title>Sistema de Monitoria - Página Principal</title>

</head>

<body>

	<table id="menu">
        
			<tr>
			
            	<td><a href="" id="linke">Login</a></td>
                <td><a href="login.do" id="linkc">Entrar</a></td>
               	<td><a href="" id="linkd">Cadastro</a></td>
                <td><a href="professor.jps" id="linka">Professor</a></td>
                <td><a href="" id="linkb">Aluno</a></td>
                        
            </tr>
                        
        </table>
	
	<table id="rodape">
             
             <tr>
                 
                <td> <img src="logo-tads2.png" alt="logo do tads"/> </td>
                <td> <img src="ifpe.jpg" id="ifpe" alt="logo do ifpe"/> </td>
                
            </tr>
            
         </table>

</body>

</html>