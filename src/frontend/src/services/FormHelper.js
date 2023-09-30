global.jQuery = require('jquery');
var $ = global.jQuery;
window.$ = $;

class FormHelper {
    showInputErrors(response) {
         $.each( response, function( id, error_message ) {
            $('#'+id).addClass('is-invalid');
            $('#'+id).after('<div class="invalid-feedback">'+error_message+'</div>');
         });
    }
    clearFormErrors(){
        $('.is-invalid').removeClass('is-invalid');
        $('.invalid-feedback').remove();
    }
}

export default new FormHelper();