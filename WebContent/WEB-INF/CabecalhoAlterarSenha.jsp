<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!--   <link rel="shortcut icon" href="images/favicon.gif" /> -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="css/jquery-ui.css" type="text/css" />
<script src="js/jquery-ui-1.11.4/external/jquery/jquery.js"></script>
<script src="js/jquery-ui-1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="css/cabecalho.css" />
<link rel="stylesheet" type="text/css" href="css/menuAlterarSenha.css" />
<link rel="stylesheet" type="text/css" href="css/toggle-button.css" />
<script type="text/javascript" src="js/cabecalho.js"></script>
<title>Monitoria IFPE-TADS</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script> //evento lista página carregada
            
             $("#menu1").ready(function()
             {
                
                $("#menu2").hide();
               
             });
            
        </script>
        
       
        
        <script> //evento lista elemento da lista clicado
            
            $(document).ready(function()
            {
                $("#menu1").click(function()
                {
                
                    $("#menu2").slideToggle("slow");
                
                });
                
            });
            
	</script>
        
       
        
        
        
        <script> //evento links
        
            $(document).ready(function()
            {
                $("[href]").css("color","white");
                    $("#home").mouseover(function() 
                    {
                        
                        $("#home").css("color","deeppink");
                        
                    });
                    
                     $("#alterarSenha").mouseover(function() 
                    {
                        
                        $("#alterarSenha").css("color","deeppink");
                        
                    });
                    
                  
                    
                      $("#home").mouseout(function() 
                    {
                        
                        $("#home").css("color","white");
                        
                    });
                    
                   
                    
                    $("#alterarSenha").mouseout(function()
                    {
                        
                        $("#alterarSenha").css("color","white");
                                
                    });
                    
                  
                    
                    
	});
</script>
        
<script>
	$(document).ready(function() {

		$('a.toggler').click(function() {
			$(this).toggleClass('off');
			var sategy = $(this).text();
			if (sategy == "JPA") {
				$(this).text('JDBC');
			} else if (sategy == "JDBC") {
				$(this).text("JPA");
			}
			sategy = $(this).text();

			$.post("alterarEsategiaPersistencia", {
				persistencia : sategy
			});

		});
	});
</script>



</head>
<body>
	<!--Header Begin-->
	<div id="header">
		<c:choose>
			<c:when test="${not empty requestScope.ERRO_ACESSO_NEGADO}">

				<div class="ui-widget">
					<div class="ui-state-error ui-corner-all"
						style="padding: 0 .7em; background-color: red;">
						<p>
							<span class="ui-icon ui-icon-alert"
								style="float: right; margin-right: .3em;"></span> <strong>Alert:</strong>
							${requestScope.ERRO_ACESSO_NEGADO }
						</p>
					</div>
				</div>
			</c:when>
			<c:otherwise>
				<div class="center">
					<div id="logo">
						<a href="acesso.do">Monitoria IFPE-TADS</a>
					</div>
					
					<!--Menu Begin-->
					<div id="menu1">
						<div id="menu2">
							<p><a id="home" href="acesso.do">Home</a> </p>
                            <p><a id="alterarSenha" href="AlterarSenha.jsp">Alterar Senha</a></p>
                            
                            
						</div>
					</div>
					<!--Menu END-->
					
					<div id="menu">
						<ul>
							
							<li><a href="#" class="toggler">JPA</a></li>
						</ul>
					</div>
					
					
				</div>
			</c:otherwise>
		</c:choose>
	</div>
	<!--Header END-->
	<!--Toprow Begin-->
	<div id="toprow">
		<div class="center">
			<div id="cubershadow">
</body>
</html>