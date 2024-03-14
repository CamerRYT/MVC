<%-- 
    Document   : registro
    Created on : 4 mar. 2024, 09:44:46
    Author     : camer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%><!--tiene contenido que acepta codigo java-->
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <form name="formulario" 
                  action="guardarAlumno"
                  method="post"    >
                <label>Nombre: </label>
                <br>
                <input type="text" 
                       name="nombre" >
                <br>
                <label>Apellido Paterno: </label>
                <br>
                <input type="text" 
                       name="appat" >
                <br>
                <label>Apellido materno: </label>
                <br>
                <input type="text" 
                       name="apmat" >
                <br>
                <label>Edad: </label>
                <br>
                <input type="text" 
                       name="edad" >
                <br>
                <input type="submit" name="enviar"
                       value="Registrar Alumno">
                <input type="reset" name="borrar"
                       value="Borrar Datos">
            </form>
            
            <br>
            
            <a href="Consultar" >Consultar Lista</a>
            
            <br>
            <form method="get" name="delete" action="Eliminar"> 
                <br>
                <label>Ingresa la Boleta del estudiante que 
                    deseas dar de baja</label>
                <br>
                <input type="text" name="boletaeliminada" >
                <br>
                <input type="submit" value="Dar de Baja">
            </form>
        </div>
    </body>
</html>
