$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/turnos/siguienteSemana",
            success: function(response){
              $.each(response, (i, consulta) => {

                let consultaRow ='<td class=\"td_paciente\">' + consulta.nombreOdontologo + '</td>' +
                          '<td class=\"td_odontologo\">' + consulta.apellidoOdontologo + '</td>' +
                          '<td class=\"td_paciente\">' + consulta.nombrePaciente + '</td>' +
                          '<td class=\"td_odontologo\">' + consulta.apellidoPaciente + '</td>' +
                          '<td class=\"td_fecha\">' + consulta.fecha + '</td>' +
                          '</tr>';
                $('#consultaTable tbody').append(consultaRow);
              });
            },
            error : function(e) {
              alert("ERROR: ", e);
              console.log("ERROR: ", e);
            }
        });
    })();

    (function(){
        let pathname = window.location.pathname;
        if (pathname == "/consultas.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});