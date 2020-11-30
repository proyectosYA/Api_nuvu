

// Get all clientes 
var  url = "http://localhost:8082/Api_Nuvu/api/usuarios"

var request = new XMLHttpRequest();
request.open('GET', url, true);
request.setRequestHeader('Authorization', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwZXBlIiwiaWF0IjoxNjA2Njk4MTcyLCJleHAiOjE2MDY2OTkwNzIsImVtYWlsIjoibWllbWFpbEB4eHguY29tLmNvIn0.V0wAVQqZ9maG457wolIoTU8aBeUS2cHZXdc7-4bf4NE');
request.responseType = 'json';
request.send();
request.onload = function () {

    if (request.readyState == 4 && request.status == "200") {
        var datos = request.response;

        productosDatos(datos);
        console.log(datos);
    }
};

function productosDatos(jsonObj) {
    var cabecera = new Array();
    cabecera[0] = "Nombre";
    cabecera[1] = "Apellido";
    cabecera[2] = "Cedula";
    cabecera[3] = "Telefono";
    cabecera[4] = "Usuario";
    var table = document.createElement("TABLE");
    table.setAttribute("id", "myTable");

    document.body.appendChild(table);
    var tr = document.createElement("TR");
    tr.setAttribute("id", "mytr");
    document.getElementById("myTable").appendChild(tr);

    //creando la cabecera apartir del arreglo cabecera
    for (var i = 0; i < cabecera.length; i++) {
        var td = document.createElement("TD");
        var cabec = document.createTextNode(cabecera[i]);
        td.setAttribute('style', 'table-layout:auto; width:150px;  font-weight: bold;');

        td.appendChild(cabec);

        document.getElementById("mytr").appendChild(td);

    }
    ;

    var h2 = document.createElement("h2");
    var texto = document.createTextNode("texto en un h2");
    h2.appendChild(texto);


    //accediendo al div con la clase = row del body
    console.log(document.body.childNodes[3].childNodes[1].childNodes[1].appendChild(table));

    for (var j = 0; j < jsonObj.length - 1; j++) {

        var tr = document.createElement("TR");
        tr.setAttribute("id", "mytr" + j);
        document.getElementById("myTable").appendChild(tr);
        var td = document.createElement("TD");

        var info = document.createTextNode(jsonObj[j].nombre);
        td.appendChild(info);
        document.getElementById("mytr" + j).appendChild(td);

        var td = document.createElement("TD");

        var info = document.createTextNode(jsonObj[j].apellidos);
        td.appendChild(info);
        document.getElementById("mytr" + j).appendChild(td);

        var td = document.createElement("TD");

        var info = document.createTextNode(jsonObj[j].cedula);
        td.appendChild(info);
        document.getElementById("mytr" + j).appendChild(td);

        var td = document.createElement("TD");

        var info = document.createTextNode(jsonObj[j].telefono);
        td.appendChild(info);
        document.getElementById("mytr" + j).appendChild(td);

        var td = document.createElement("TD");
        var info = document.createTextNode(jsonObj[j].usuario);
        td.appendChild(info);

        document.getElementById("mytr" + j).appendChild(td);
        //console.log(jsonObj[i].titulo);

    };
}



