 
function agregar() { 
    var cedula = document.getElementById("cedula").value;
    var nombre = document.getElementById("nombre").value;
    

    var usuarioSend = {
        identificacion: cedula,
        nombre: nombre
        
    };
    var url = "http://localhost:8082/Api_Nuvu/api/tarjetas/agregar";
    var request = new XMLHttpRequest();
    request.open('POST', url, true);
    request.setRequestHeader('Authorization', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwZXBlIiwiaWF0IjoxNjA2Njk1NjYwLCJleHAiOjE2MDY2OTY1NjAsImVtYWlsIjoibWllbWFpbEB4eHguY29tLmNvIn0.GcQkRtsADeJeal7kFrVasljQt673FrsP0d9xsISMzEQ');
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