<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="listas_professor.css" media="screen"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script> 
            
             $("a").ready(function()
             {
                
                    $("#panel").hide();
                    
             });
            
        </script>
        
        <script> 
            
             $("a").ready(function()
             {
                
                $("#panel1").hide();
                
             });
            
        </script>
        
        <script> 
            
            $(document).ready(function()
            {
                $("div a").first().click(function()
                {
                
                    $("#panel").slideToggle("slow");
                
                });
                
            });
            
	</script>
        
        <script> 
            
            $(document).ready(function()
            {
                $("a").last().click(function()
                {
                     
                    $("#panel1").slideToggle("slow");
                    
                });
                
            });
            
	</script>
	
	<title>Sistema Monitoria - Professor</title>

</head>

<body>
	
	<div id="flip">Alunos monitores</div>
	
	<div id="panel">
		
		<ol>
		
			<li>Laura Regina</li>
			<li>Edmilson Santana</li>
			<li>Douglas Albuquerque</li>
		
		</ol>
		
	</div>
	
	<div id="flip">Situação dos alunos monitores</div>
	
	<div id="panel">
		
		<ol>
		
			<li>Laura Regina - pendente</li>
			<li>Edmilson Santana - ok</li>
			<li>Douglas Albuquerque - ok</li>
		
		</ol>
		
	</div>

</body>

</html>