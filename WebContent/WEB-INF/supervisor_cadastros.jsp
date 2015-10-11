<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="menu.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="rodape.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="form_supervisor_cadastro_aluno.css" media="screen"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        
        <script> //eventos de formulário
            
            $(document).ready(function()
            {      
                $("#button1").css({"background-color": "deeppink", "color": "white", "width": "130px", "height": "40px", "font-family": "serif", "font-size": "20px", "border-radius": "10px 10px 10px 10px", "padding": "5px"});
                $("p").css({"font-family": "serif", "font-size": "13pt"});
                
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
                    
                    $("#button1").last().mouseover(function() 
                    {
                        
                        $("#button1").css("color","black");
                        
                    });
                    
                    $("[href]").mouseout(function()
                    {
                        
                        $("[href]").css("color","white");
                                
                    });
                    
                     $("li").mouseout(function()
                    {
                        
                        $("li").css("color","white");
                                
                    });
                    
                    $("#button1").mouseout(function() 
                    {
                        
                        $("#button1").css("color","white");
                        
                    });
            });
            
        </script>
    
<title>Sistemas Monitora - Orientador</title>
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
        
        <p id="titulo_form">Cadastrar aluno monitor </p>
        
	<form action="" method="post">
		
		<fieldset>
            
            <p>
                        
             	<label id="nome">Nome</label>
                <input type="text" id="nome1" name="nome" required="required" placeholder="Informe seu nome..." />
                        
            </p>
                    
            <p>
                        
				<label id="email">E-mail</label>
				<input type="email" id="email1" name="email" required="required" placeholder="Informe seu e-mail..." />
                        
           	</p>
                    
             <p>
                        
             	<label id="matricula">Matrícula</label>
				<input type="text" name="matricula" id="matricula1" required="required" placeholder="Informe sua matrícula..." />
                        
		    </p>
                    
            <p>
                        
            	<label id="curso">Curso</label>
				<input type="text" name="curso" id="curso1" required="required" placeholder="Informe seu curso..." />
                        
		    </p>	
                    
            <p>
                        
            	<label id="orientador">Nome Orientador</label>
				<input type="text" id="orientador1" name="orientador" required="required" placeholder="Informe a sua senha..." />
                    
            </p>
                        
            <p>
                        
            	<label id="disciplina">Disciplina</label>
				<input type="text" id="disciplina1" name="disciplina" required="required" placeholder="Informe a disciplina..." />
                    
           </p>    
                    
           <p>
               <label id="button"> </label>
               <input type="submit" value="Cadastrar" name="button" id="button1" />
			
            </p>
                    
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