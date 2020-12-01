function buscarCedulaTarjeta() {
    var cedula = document.getElementById("search").value;
    var url = "http://localhost:8082/Api_Nuvu/api/tarjetas"+cedula;
      
    var request = new XMLHttpRequest();
    request.open('GET', url, true);
    request.setRequestHeader('Authorization', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwZXBlIiwiaWF0IjoxNjA2Njk4OTc3LCJleHAiOjE2MDY2OTk4NzcsImVtYWlsIjoibWllbWFpbEB4eHguY29tLmNvIn0.0TPJEx4Bow_ENpyps85jZ1m_hMvjl90GodumAWGPWxI');
    request.responseType = 'json';
    request.send();
    request.onload = function () {

        if (request.readyState == 4 && request.status == "200") {
            var datos = request.response;
            usuariosDatos(datos);
            console.log(datos);

        }
    };
}


function buscarCedulaUsuario() {
    var cedula = document.getElementById("search").value;

      var url = "http://localhost:8082/Api_Nuvu/api/tarjetas"+cedula;

    var request = new XMLHttpRequest();
    request.open('GET', url, true);
    request.setRequestHeader('Authorization', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwZXBlIiwiaWF0IjoxNjA2Njk4OTc3LCJleHAiOjE2MDY2OTk4NzcsImVtYWlsIjoibWllbWFpbEB4eHguY29tLmNvIn0.0TPJEx4Bow_ENpyps85jZ1m_hMvjl90GodumAWGPWxI');
    request.responseType = 'json';
    request.send();
    request.onload = function () {

        if (request.readyState == 4 && request.status == "200") {
            var datos = request.response;
            usuariosDatos(datos);
            console.log(datos);

        }
    };
}