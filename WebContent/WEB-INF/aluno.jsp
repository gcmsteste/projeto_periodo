<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="menu_aluno.css" media="screen"/>
        <link rel="stylesheet" type="text/css" href="rodape_aluno.css" media="screen"/>
       <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        
        <script> //evento tabela relatório
            
            $(document).ready(function()
            {
                $("#relatorio").hide();
                $("#linkd").click(function()
                    {
                        $("#relatorio").toggle();
                    });
            });
        </script>
        
        <script> //evento links
        
            $(document).ready(function()
            {
                $("[href]").css("color","white");
                    
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
        
        <title>Sistema Monitoria - Aluno</title>
    </head>
    <body>
        
        <table id="menu">
			
            <tr>
                
                <td><a href="login.do" id="linkc">Aluno</a></td>
                <td><a href="" id="linkd">Relatório</a></td>
                <td><a href="" id="linke">Contatos</a></td>
                           
            </tr>
                        
        </table>
        
        <table id="relatorio">
        
            <tr>

                <td> <a href="" id="cadastro_relatorio">Cadastrar Relatório</a>  </td>
                <td><a href="">Editar Relatório</a>  </td>
                <td><a href="">Digitalizar assinatura</a></td>

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