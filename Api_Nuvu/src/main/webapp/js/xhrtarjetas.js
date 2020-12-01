

// Get all tarjetas
var url = "http://localhost:8082/Api_Nuvu/api/tarjetas";

var request = new XMLHttpRequest();
request.open('GET', url, true);
request.setRequestHeader('Authorization', 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwZXBlIiwiaWF0IjoxNjA2Njk4MTcyLCJleHAiOjE2MDY2OTkwNzIsImVtYWlsIjoibWllbWFpbEB4eHguY29tLmNvIn0.V0wAVQqZ9maG457wolIoTU8aBeUS2cHZXdc7-4bf4NE');
request.responseType = 'json';
request.send();
request.onload = function () {

    if (request.readyState == 4 && request.status == "200") {
        var datos = request.response;
        usuariosDatos(datos);
        console.log(datos);

    }
};

function usuariosDatos(jsonObj) {
    var cabecera = new Array();
    cabecera[0] = "Nombre";
    cabecera[1] = "Numero Tarjeta";
    cabecera[2] = "Identificacion";
    cabecera[3] = "Fecha Vencimiento";
    cabecera[4] = "CVV";

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

    //accediendo al div con la clase = row del body
    console.log(document.body.childNodes[3].childNodes[1].childNodes[1].appendChild(table));

    for (var j = 0; j < jsonObj.length; j++) {

        var tr = document.createElement("TR");
        tr.setAttribute("id", "mytr" + j);
        document.getElementById("myTable").appendChild(tr);



        var td = document.createElement("TD");
        var info = document.createTextNode(jsonObj[j].nombre);
        td.appendChild(info);
        document.getElementById("mytr" + j).appendChild(td);

        var td = document.createElement("TD");
        var info = document.createTextNode(jsonObj[j].numeroTarjeta);
        td.appendChild(info);
        document.getElementById("mytr" + j).appendChild(td);

        var td = document.createElement("TD");
        var info = document.createTextNode(jsonObj[j].identificacion);
        td.appendChild(info);
        document.getElementById("mytr" + j).appendChild(td);

        var td = document.createElement("TD");
        var info = document.createTextNode(jsonObj[j].fechaVencimiento);
        td.appendChild(info);
        document.getElementById("mytr" + j).appendChild(td);

        var td = document.createElement("TD");
        var info = document.createTextNode(jsonObj[j].cvv);
        td.appendChild(info);
        document.getElementById("mytr" + j).appendChild(td);

    }
    ;
}

 