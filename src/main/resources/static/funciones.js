// la funcion eliminar consulta si desea eliminar y en caso de querer envia la url borrar con su id y 
// si se hace con exito muestr el mensaje de exito
function eliminar(id) {
    Swal.fire({
        title: "¿Estas seguro de Eliminar?",
        text: "Una vez eliminado, no se puede revertir los cambios!",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Si, Estoy seguro!",
        cancelButtonText: "Cancelar"
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                url:"/borrar/"+id,
                success:function(res){
                    console.log(res);
                }
            })
            Swal.fire({
                title: "Eliminado!",
                text: "El vehículo fue eliminado con éxito!",
                icon: "success"
            }).then((result)=>{
                if(result.isConfirmed){
                    location.href="/";
                }
            });
        }
    });
}


