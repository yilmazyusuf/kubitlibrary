global.jQuery = require('jquery');
var $ = global.jQuery;
window.$ = $;

import { toast } from 'vue3-toastify';
import 'vue3-toastify/dist/index.css';

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
    toastSuccess(message){
        toast.success(message);
    }
}

export default new FormHelper();