$(document).ready(function(){
     $("#button-delete").click(function(evt) {
            evt.preventDefault();
            try {
                let pacienteId = $("#paciente_id").val();

                $.ajax({
                    url: '/pacientes/'+pacienteId,
                    type: 'DELETE',
                    async: false,
                    cache: false,
                    success: function (response) {

                        let successAlert = '<div class="alert alert-success alert-dismissible">' +
                                                '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                                '<strong> paciente eliminado </strong></div>'
                        $("#tr_" + $("#paciente_id").val()).remove();
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
});