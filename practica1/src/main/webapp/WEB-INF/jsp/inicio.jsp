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
        <style>
            #map {
                height: 400px;
                width: 100%;
            }
        </style>
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
        
        <hr>
        <h2>Buscar por correo</h2>
        <form method="GET" action="/practica1/email">
            <input id="email" name="email" type="email" placeholder="Correo" value=""/>
            <button>Buscar</button>
        </form>
        <div id="map"></div>
        <script>
            function initMap() {
                var myLatlng = new google.maps.LatLng(35.141432, -90.052629);
                var mapOptions = {
                    zoom: 21,
                    center: myLatlng,
                    mapTypeId: 'satellite'
                };
                var map = new google.maps.Map(document.getElementById('map'), 
                mapOptions);
                var marker = new google.maps.Marker({
                    position: myLatlng,
                    map: map
                });
                
                var infowindow = new google.maps.InfoWindow({
                    content: "come down and play"
                });
                
                marker.addListener('click', function() {
                    infowindow.open(map, marker);
                });
            }
        </script>
        <script async defer
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAoQY3aRFEA2zmjP7WOalzEKHd5ruwkY28&callback=initMap">
        </script>
    </body>
</html>
