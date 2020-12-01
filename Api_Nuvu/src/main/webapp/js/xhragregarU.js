function agregar() {
    var apellidos = document.getElementById("apellido").value;
    var cedula = document.getElementById("cedula").value;
    var nombre = document.getElementById("nombre").value;
    var telefono = document.getElementById("telefono").value;
    var usuario = document.getElementById("usuario").value;
    var contrasena = document.getElementById("clave").value;

    var usuarioSend = {
        cedula: cedula,
        nombre: nombre,
        apellidos: apellidos,
        telefono: telefono,
        usuario: usuario,
        contrasena: contrasena
    };
    var url = "http://localhost:8082/Api_Nuvu/api/usuarios/agregar";
    var request = new XMLHttpRequest();
    request.open('POST', url, true);
    request.setRequestHeader('Authorization', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwZXBlIiwiaWF0IjoxNjA2NjkzNzE3LCJleHAiOjE2MDY2OTQ2MTcsImVtYWlsIjoibWllbWFpbEB4eHguY29tLmNvIn0.bis768acm9xWa4NT7QVpTiWDJcDlKZxCEA29N5O1SDw');
    request.responseType = 'json';
    request.setRequestHeader('Content-Type', 'application/json');
    request.send(JSON.stringify(usuarioSend));
    console.log(usuarioSend);
    request.onload = function () {

        if (request.readyState == 4 && request.status == "200") {
            var datos = request.response;
            usuariosDatos(datos);
            console.log(datos.toString());
        }
    };
}