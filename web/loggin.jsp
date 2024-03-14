<%-- 
    Document   : loggin
    Created on : 13 mar. 2024, 15:02:52
    Author     : camer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar sesion para entrar</title>
    </head>
    <body>
        
         <h1>Ingresa los datos para ingresar a la lista de alumnos</h1>
        <br>
        
        <form method="post" name="ingresar" action="ingresar.html">
            
                <br>
                <label>Ingrese Usuario</label>
                <br>
                <input type="text" name="ingresarUser">
                <br>
                
                <label>Ingrese Contraseña</label>
                <br>
                <input type="text" name="ingresarPass">
                <br>
                <br>
                <input type="submit" value="Ingresar">
        </form>
        
        
    </body>
</html>
