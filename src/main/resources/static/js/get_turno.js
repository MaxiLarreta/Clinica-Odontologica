$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/turnos",
            success: function(response){
              $.each(response, (i, turno) => {


                let get_More_Info_Btn = '<button' +
                                            ' id=' + '\"' + 'btn_id_' + turno.id + '\"' +
                                            ' type="button" class="btn btn-info btn_id">' +
                                            turno.id +
                                            '</button>';

                let tr_id = 'tr_' + turno.id;
                let turnoRow = '<tr id=\"' + tr_id + "\"" + '>' +
                          '<td>' + get_More_Info_Btn + '</td>' +
                          '<td class=\"td_paciente\">' + turno.pacienteDNI + '</td>' +
                          '<td class=\"td_odontologo\">' + turno.odontologoMatricula + '</td>' +
                          '<td class=\"td_fecha\">' + turno.fecha + '</td>' +
                          '</tr>';
                $('#turnoTable tbody').append(turnoRow);
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
        if (pathname == "/turnos.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});