<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

        <link rel="stylesheet" type="text/css" href="menu_supervisor.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="rodape.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="supervisor_lista_aluno.css" media="screen"/>
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
                    
                    $("#linkf").mouseover(function() 
                    {
                                
                    	$("#linkf").css("color","deeppink");
                                
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
        
	
	<title>Sistema Monitoria - Supervisor - listagem de alunos</title>
        
    </head>
    

<body>
        <link rel="/monitoria.ico" href=""/>
        <table id="menu">
			
            <tr>
                
                <td><a href="login.do" id="linkc">Supervisor</a></td>
                <td><a href="" id="linkd">Cadastrar aluno</a></td>
                <td><a href="" id="linke">Cadastrar professor</a></td>
                <td><a href="" id="linka">Alunos</a></td>
                <td><a href="" id="linkf">Professores</a></td>
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
	
	<table id="rodape">
             
             <tr>
                 
                <td> <img src="logo-tads2.png" alt="logo do tads"/> </td>
                <td> <img src="ifpe.jpg" id="ifpe" alt="logo do ifpe"/> </td>
                
            </tr>
            
         </table>
    </body>
</html>