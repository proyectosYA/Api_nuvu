function up() {
    var user = document.getElementById("user").value;
    var passw = document.getElementById("pass").value; 
    
    var usuarioSend = {
        usuario: user,
        contrasena:passw
    };

    var url = "http://localhost:8082/Api_Nuvu/api/signin";
     var request = new XMLHttpRequest();
    request.open('POST', url, true);  
    request.responseType = 'json';
    request.setRequestHeader('Content-Type', 'application/json');
    request.send(JSON.stringify(usuarioSend));
    request.onload = function () {

        if (request.readyState == 4 && request.status == "200") {
            var datos = request.response;
            usuariosDatos(datos); 
            console.log(datos.toString());
        }
    };
    
}