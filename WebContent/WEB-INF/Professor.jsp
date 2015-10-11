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
	
	<script>
            
            $(document).ready(function()
            {
                
                $("#aluno1").hide();
               
                $(document).ready(function()
                {
                    $("#link_aluno1").click(function()
                    {
                        
                        $("#aluno1").toggle();
                        
                    });
                });
                
            });
            
        </script>
	
	<title>Sistema Monitoria - Professor</title>

</head>

<body>
	
	<div id="flip"><a href="#menu" id="link1">Alunos monitores</a></div>
	
	<div id="panel">
		
		<ol>
		
			<li> <a href="#aluno1" id="link_aluno1">Laura Regina</a> </li>
			<li>Edmilson Santana</li>
			<li>Douglas Albuquerque</li>
		
		</ol>
		
	</div>
	
         <div id="flip1"><a href="#menu" id="link2">Situação dos alunos monitores</a></div>
	
	<div id="panel1">
		
		<ol>
		
            <li>Laura Regina - pendente</li>
			<li>Edmilson Santana - ok</li>
			<li>Douglas Albuquerque - ok</li>
		
		</ol>
		
	</div>
         
         <table id="aluno1">
             
             <tr>
                 
                 <td>Nome:Laura Regina</td>
                 
             </tr>
             
             <tr>
                 
                 <td>Matrícula:20141Y6-RC0471</td>
                 
             </tr>
             
             <tr>
                 
                 <td>Curso:Anáilise de Sistemas</td>
                 
            </tr>
            
            <tr>
                
                 <td>Disciplina:Arquitetura de Computadores</td>
                 
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