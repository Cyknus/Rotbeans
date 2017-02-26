<%-- 
    Document   : registro
    Created on : Feb 25, 2017, 8:01:28 PM
    Author     : Cygnus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    </head>
    <body>
        <h1>Registro</h1>
        <form method="GET" action="/practica1/registrado">
            <label>Nombre: </label>
            <input id="name" name="name" type="text" placeholder="prro">
            <br>
            <label>Carrera: </label>
            <input id="career" name="career" type="text" placeholder="Informática">
            <br>
            <label>Fecha de nacimiento: </label>
            <input type="number" name="day" min="1" max="31">
            <input type="number" name="month" min="1" max="12">
            <input type="number" name="year" min="1" max="2017">
            <br>
            <label>Correo: </label>
            <input id="email" name="email" type="email" placeholder="@ciencias.unam.mx">
            <br>
            <label>Contraseña: </label>
            <input id="psswd" name="psswd" type="password" placeholder="lel">
            <br>
            <button>Aceptar</button>
        </form>
    </body>
</html>
