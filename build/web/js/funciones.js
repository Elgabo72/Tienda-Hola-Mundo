$(document).ready(function () {
    $("tr #btnDelete").click(function () {
        var idp = $(this).parent().find("#idp").val();
        swal({
            title: "Esta Seguro de Eliminar?",
            text: "Once deleted, Usted puede agregar de nuevo!",
            icon: "warning",
            buttons: true,
            dangerMode: true,
        }) .then((willDelete) => {
                    if (willDelete) {
                        eliminar(idp);
                        swal("Poof! Libro Eliminado!", {
                            icon: "success",
                        }).then((willDelete)=>{
                            if(willDelete){
                                parent.location.href="Controller?action=Carrito"
                            }
                        });
                    } else {
                        swal("Registro no eliminado!");
                    }
                });

    });
    function eliminar(idp) {
        var url = "Controller?action=Delete";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idp=" + idp,
            success: function (data, textStatus, jqXHR) {
                
            }
        });
    }
    
    $("tr #Cantidad").click(function (){
        var idp = $(this).parent().find("#idpro").val();
        var cantidad = $(this).parent().find("#Cantidad").val();
        var url = "Controller?action=ActualizarCantidad";
        $.ajax({
            type: 'POST',
            url: url,
            data: "idp=" + idp + "&Cantidad=" + cantidad,
            success: function (data, textStatus, jqXHR) {
                location.href="Controller?action=Carrito";
            }
        });
    });
    
    
});





