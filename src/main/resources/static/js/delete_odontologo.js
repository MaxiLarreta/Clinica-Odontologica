$(document).ready(function(){
     $("#button-delete").click(function(evt) {
            evt.preventDefault();
            try {
                let odontologoId = $("#odontologo_id").val();

                $.ajax({
                    url: '/odontologos/'+odontologoId,
                    type: 'DELETE',
                    async: false,
                    cache: false,
                    success: function (response) {

                        let successAlert = '<div class="alert alert-success alert-dismissible">' +
                                                '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                                '<strong> odontologo eliminado </strong></div>'
                        $("#tr_" + $("#odontologo_id").val()).remove();
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