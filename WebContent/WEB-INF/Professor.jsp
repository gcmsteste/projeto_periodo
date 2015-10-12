<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="menu_professor.css" media="screen"/>
    <link rel="stylesheet" type="text/css" href="rodape.css" media="screen"/>
	<link rel="stylesheet" type="text/css" href="listas_professor.css" media="screen"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script> //evento lista página carregada
            
             $("a").ready(function()
             {
                
                $("#panel").hide();
                    
             });
            
        </script>
        
        <script> //evento lista carregada
            
             $("a").ready(function()
             {
                
                $("#panel1").hide();
                
             });
            
        </script>
        
        <script> //evento lista elemento da lista clicado
            
            $(document).ready(function()
            {
                $("div a").first().click(function()
                {
                
                    $("#panel").slideToggle("slow");
                
                });
                
            });
            
	</script>
        
        <script>  //evento lista elemento da lista clicado
            
            $(document).ready(function()
            {
                $("a").last().click(function()
                {
                     
                    $("#panel1").slideToggle("slow");
                    
                });
                
            });
            
	</script>
        
        <script> //evento lista, mostrar dados do primeiro aluno
            
            $(document).ready(function()
            {
                
                $("#aluno1").hide();
                $("#link_aluno1").click(function()
                {
                        
                    $("#aluno1").toggle();
                        
                });
                    
             });
                      
        </script>
        
        <script> //evento lista, mostrar dados do segundo aluno
            
            $(document).ready(function()
            {
                $("#aluno2").hide();
                $("#link_aluno2").click(function()
                    {
                        
                        $("#aluno2").toggle();
                        
                    });
                    
            });
        </script>
        
        <script> //evento lista, mostrar dados do terceiro aluno
            
            $(document).ready(function()
            {
                $("#aluno3").hide();
                $("#link_aluno3").click(function()
                    {
                        
                        $("#aluno3").toggle();
                        
                    });
            });
        </script>
        
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
                    
                    $("#link1").mouseover(function() 
                    {
                        
                        $("#link1").css("color","deeppink");
                        
                    });
                    
                    $("#link2").mouseover(function() 
                    {
                        
                        $("#link2").css("color","deeppink");
                        
                    });
                    
                    $("li").first().mouseover(function() 
                    {
                        
                        $("#link_aluno1").css("color","deeppink");
                        
                    });
                    
                    $("[href]").mouseout(function()
                    {
                        
                        $("[href]").css("color","white");
                                
                    });
                    
                     $("li").mouseout(function()
                    {
                        
                        $("li").css("color","white");
                                
                    });
            });
            
        </script>
        
	
	<title>Sistema Monitoria - Professor</title>
        
    </head>
    
    <body>
         <link rel="/monitoria.ico" href=""/>
        <table id="menu">
			
            <tr>
                
                <td><a href="login.do" id="linkc">Professor</a></td>
                <td><a href="" id="linkd">Cadastrar aluno</a></td>
                <td><a href="" id="linka">Alunos</a></td>
                <td><a href="" id="linkb">Relatórios</a></td>
                        
            </tr>
                        
        </table>
         
             
         <div id="flip"><a href="#menu" id="link1">Alunos monitores</a></div>
	
		<div id="panel">
		
			<ol>
			
				<li> <a href="#aluno1" id="link_aluno1">Laura Regina</a> </li>
	            <li><a href="#aluno2" id="link_aluno2">Edmilson Santana</a></li>
	            <li><a href="#aluno3" id="link_aluno3">Douglas Albuquerque</a></li>
			
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
        
         <table id="aluno2">
             
             <tr>
                 
                 <td>Nome:Edmilson Santana</td>
                 
             </tr>
             
             <tr>
                 
                 <td>Matrícula:20141Y6-RC0915</td>
                 
             </tr>
             
             <tr>
                 
                 <td>Curso:Anáilise de Sistemas</td>
                 
            </tr>
            
            <tr>
                
                 <td>Disciplina:Introdução a Programação</td>
                 
            </tr>
                 
            
         </table>
         
         <table id="aluno3">
             
             <tr>
                 
                 <td>Nome:Douglas Albuquerque</td>
                 
             </tr>
             
             <tr>
                 
                 <td>Matrícula:20141Y6-RC1018</td>
                 
             </tr>
             
             <tr>
                 
                 <td>Curso:Anáilise de Sistemas</td>
                 
            </tr>
            
            <tr>
                
                 <td>Disciplina:Linguagem de Programação Orientada a Objetos</td>
                 
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
ml>