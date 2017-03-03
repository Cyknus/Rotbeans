<%-- 
    Document   : resu
    Created on : Mar 3, 2017, 2:54:14 AM
    Author     : Cygnus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        <h1>${info}</h1>
        <h1>${user.getEmail()}</h1>
        <h1>${user.getPersona().getNombre()}</h1>
        <h1>${user.getPersona().getFechaNacimiento()}</h1>
        <h1>${user.getPersona().getCarrera()}</h1>
    </body>
</html>
