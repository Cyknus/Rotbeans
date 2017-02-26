<%-- 
    Document   : inicio
    Created on : 20/02/2017, 11:08:36 PM
    Author     : jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
    </head>
    <body>
        <h2>Inicia sesión</h2>
        <form method="POST" action="/practica1/sesion">
            <label>Correo: </label>
            <input id="email" name="email" type="text" placeholder="lol">
            <br>
            <label>Contraseña: </label>
            <input id="psswd" name="psswd" type="password" placeholder="lel">
            <br>
            <button>Aceptar</button>
        </form>
    </body>
</html>
