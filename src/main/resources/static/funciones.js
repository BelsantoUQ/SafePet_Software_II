function eliminarAfiliado(codigo){
    swal({
        title: "¿Seguro que quieres eliminar el afiliado?",
        text: "Una vez eliminado ya no se podrá recuperar",
        icon: "warning",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax({
                   url:"/eliminar/"+codigo,
                   success: function(res){
                       console.log(res);
                   }
                });
                swal("Listo! Se ha eliminado el afiliado!", {
                    icon: "success",
                }).then((ok)=>{
                  if(ok){
                      location.href="/listarAfiliado";
                  }

                });
            } else {
                swal("El afiliado no ha sido eliminado");
            }
        });
}