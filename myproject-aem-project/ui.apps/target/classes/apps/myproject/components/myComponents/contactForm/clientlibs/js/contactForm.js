console.log("form js");
$(document).ready(function(){

    $(".button").on("click", function(){
        var companyName = $('#companyName').val();
        var name = $('#name').val();
        var phoneNumber = $('#phoneNumber').val();
        var country = $('#country').val();
        var recaptcha = $("#g-recaptcha-response").val();

        if(recaptcha){
            $.ajax({
                url :'/bin/ContactFormServlet',
                type:'POST',
                async: false,
                data: {
                    'companyName' : companyName,
                    'name' : name,
                    'phoneNumber' : phoneNumber,
                    'country' : country,
                    'g-recaptcha-response' : recaptcha,
                },
                dataType: 'text',
                success: function(xhr, status, success){
                    if(xhr.status =200){
                        console.log("data sent successfully");
                    }else {
                        console.log("data went wrong");
                    }
                }
            });
       }else {
            alert('please verify captcha');
            return false;
        }
    });
});
