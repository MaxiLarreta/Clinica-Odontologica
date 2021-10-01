$(document).ready(function(){
    $("#button-update").click(function(evt) {
        evt.preventDefault();
        try {
            let turnoId = $("#turno_id").val();

        let formData = {
            id: $("#turno_id").val(),
            pacienteDNI : $("#paciente").val(),
            odontologoMatricula :  Number($("#odontologo").val()),
            fecha: $("#fecha").val()
        }

            $.ajax({
                url: '/turnos',
                type: 'PUT',
                contentType : "application/json",
                data: JSON.stringify(formData),
                dataType : 'json',
                async: false,
                cache: false,
                success: function (response) {
                    let turno = response;

                    let successAlert = '<div class="alert alert-success alert-dismissible">' +
                                            '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                            '<strong> turno actualizado </strong></div>'


                    $("#tr_" + turnoId + " td.td_paciente").text(turno.pacienteDNI);
                    $("#tr_" + turnoId + " td.td_odontologo").text(turno.odontologoMatricula);
                    $("#tr_" + turnoId + " td.td_fecha").text(turno.fecha ? turno.fecha.toString() : '');

                    $("#response").empty();
                    $("#response").append(successAlert);
                    $("#response").css({"display": "block"});
                },

                error: function (response) {
                    let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                        '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                        '<strong> Error </strong></div>';

                    $("#response").empty();
                    $("#response").append(errorAlert);
                    $("#response").css({"display": "block"});
                }
            });
        } catch(error){
            console.log(error);
            alert(error);
        }
    });

    $(document).on("click", "table button.btn_id", function(){
        let id_of_button = (event.srcElement.id);
        let turnoId = id_of_button.split("_")[2];

        $.ajax({
            url: '/turnos/' + turnoId,
            type: 'GET',
            success: function(response) {
                let turno = response;
                $("#turno_id").val(turno.id);
                $("#paciente").val(turno.pacienteDNI);
                $("#odontologo").val(turno.odontologoMatricula);
                $("#fecha").val(turno.fecha);
                $("#div_turno_updating").css({"display": "block"});
            },
            error: function(error){
                console.log(error);
                alert("Error -> " + error);
            }
        });
    });
});