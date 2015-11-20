<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="images/favicon.gif" />
<script type="text/javascript" src="js/cabecalho.js"></script>
<link rel="stylesheet" type="text/css" href="css/cabecalho.css" />
<link rel="stylesheet" type="text/css" href="css/cabecalhoProfessor.css" />
<link rel="stylesheet" type="text/css" href="css/toggl-button-professor.css" />

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
                    
                     $("#logout").mouseover(function() 
                    {
                        
                        $("#logout").css("color","deeppink");
                        
                    });
                    
                  
                    
                      $("#home").mouseout(function() 
                    {
                        
                        $("#home").css("color","white");
                        
                    });
                    
                   
                    
                    $("#logout").mouseout(function()
                    {
                        
                        $("#logout").css("color","white");
                                
                    });
                    
                  
                    
                    
	});
</script>

<script>
	$(document).ready(function() {

		$('a.toggler').click(function() {
			$(this).toggleClass('off');
			var strategy = $(this).text();
			if (strategy == "JPA") {
				$(this).text('JDBC');
			} else if (strategy == "JDBC") {
				$(this).text("JPA");
			}
			strategy = $(this).text();

			$.post("alterarEstrategiaPersistencia", {
				persistencia : strategy
			});

		});
	});
</script>


</head>
<body>
	<!--Header Begin-->
	<div id="header">
		
				<div class="center">
					<div id="logo">
						<a href="acesso.do">Monitoria IFPE-TADS</a>
					</div>
					
					<div id="menu">
						<ul>
							
							<li><a href="#" class="toggler">JPA</a></li>
						</ul>
					</div>
						
				</div>	
	</div>
	
	<!--Header END-->
	<!--Toprow Begin-->
	
			
			
	<!--Menu Begin-->
					<div id="menu1">
						<div id="menu2">
							<p><a id="home" href="acesso.do">Home</a> </p>
                            <p><a id="alterarSenha" href="AlterarSenha.jsp">Alterar Senha</a></p>
                            
                            
						</div>
					</div>
					<!--Menu END-->
</body>
</html>