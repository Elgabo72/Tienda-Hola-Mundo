$('#enviar').click(function (){
    
    $.ajax({
                        type: 'POST',
                        contentType: 'application/json',
                        url: "/TiendaVirtualHM/registrarcompra",
                        data: JSON.stringify({
                            nombre: $("#txtnombrecli").val(),
                            apellido: $("#txtapellidocli").val(),
                            dni: $("#txtdnicli").val(),
                            telefono: $("#txttelefonocli").val(),
                            correo: $("#txtcorreocli").val(),
                            edad: $("#txtedadcli").val(),
                            direccion: $("#txtdireccion").val()
                        }),
                        success: function (data, textStatus, jqXHR) {
                            if (data) {
                                alert('DATOS REGISTRADOS CORRECTAMENTE');
                               
                                //$("#modal_registrar").modal("hide");
                            } else {
                                alert('error');
                            }
                        }
                    
                });
   
   
});