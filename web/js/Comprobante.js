

window.onload = function () {
    var fecha = new Date();
    var hoy = fecha.getDate() + "/" + (fecha.getMonth() + 1) + "/" + fecha.getFullYear();
    var respuesta = JSON.parse(localStorage["SUBTOTAL"]);
    respuesta.forEach(element => {
        if (element['id']) {
            let factura = document.querySelector('#factura');
            const row = document.createElement('tr');
            row.innerHTML = `
                                        <td>
                                            ${element['id']}
                                        </td>
                                        <td>
                                            ${element['producto']}
                                        </td>
                                        <td>${hoy}</td>   
                                        
                                        <td>
                                            ${element['subtotal']}
                                        </td>
                                    `;
            factura.appendChild(row);
        }
    });
    var res = localStorage.getItem('TOTAL');
    $('#total').text(res);
}


