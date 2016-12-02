/**
 * Created by Prajwal on 11/20/2016.
 */
$(function () {
    $("#signup").validate({
        rules:{
            password:{
                required:true,
                minlength: 8
            },
            repassword:{
              required:true,
                equalTo:"#password1",
                minlength: 8

            }
        }
    })
});