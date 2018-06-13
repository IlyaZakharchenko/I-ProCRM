var viewButton3 = $("#view_button3");
var viewButton4 = $("#view_button4");
var pass =  $("#password");
var verPass = $("#verifypassword");
var mess = $('#message');
var mess1 = $('#message1');
var mess2 = $('#message2');
var mess3 = $('#message3');
var mess4 = $('#message4');
var mess5 = $('#message5');
var mess6 = $('#message6');
var mess7 = $('#message7');
var mess8 = $('#message8');
var mess10 = $('#message10');

$(document).ready(function() {
    viewButton3.bind("mousedown touchstart", function() {
        pass.attr("type", "text");
    });
    viewButton3.bind("mouseup touchend", function() {
        pass.attr("type", "password");
    });
    viewButton4.bind("mousedown touchstart", function() {
        verPass.attr("type", "text");
    });
    viewButton4.bind("mouseup touchend", function() {
        verPass.attr("type", "password")
    })
});
function passwordChecker(){
    verPass.val('');
    mess1.html(''); mess8.html(''); mess10.html('');
    mess.html('');mess2.html('');mess3.html('');mess4.html('');mess5.html('');mess6.html('');mess7.html('');
    if(pass.text().length >= 4){
        if(newValPassPoilcy()===true ){
            mess.css('color','green');
            mess.html('Although looks like a good password, try to make it more stronger');
            if(pass.val().length>=9){
                mess.html('');
                mess1.html('');
            }
            return true;
        }
    }
}

/**
 * @return {boolean}
 */
function NumAndWordRep(){
    var password = pass.val().toLowerCase();
    if(password.match(/(.)\1\1/)){
        mess7.css('color','red');
        mess7.html('Пароль не должен содержать повторяющиеся символы.');
        return false;
    }
    return true;
}
function  newValPassPoilcy(){

    var password = pass.val();
    if(!password.match(/^(?=.{6,})(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&_+=*\-(){}:;<>|,.?/'"]).*$/) || NumAndWordRep()===false){

        mess8.css('color','red');
        mess8.html('Ваш пароль должен содержать:-');
        if(!password.match(/^(?=.{6,}).*$/)){
            mess.css('color','red');
            mess.html(' - минимум 6 символов.');

        }
        if(!password.match(/^(?=.*[0-9]).*$/)){
            mess2.css('color','red');
            mess2.html(' - хотя бы одну цифру.');

        }
        if(!password.match(/^(?=.*[a-z]).*$/))
        {
            mess3.css('color','red');
            mess3.html(' - хотя бы одну прописную букву.');

        }
        if(!password.match(/^(?=.*[A-Z]).*$/)){
           mess4.css('color','red');
           mess4.html(' - хотя бы одну заглавную букву.');

        }
        if(!password.match(/^(?=.*[!@#$%^&_+=*\-(){}:;<>|,.?/'"]).*$/)){

            mess5.css('color','red');
            mess5.html(' - хотя бы один специальный символ.');

        }
        if(NumAndWordRep()===false){
            if(password.match(/^(?=.{6,})(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&_+=*\-(){}:;<>|,.?/'"]).*$/)){
                mess8.html('');
            }

        }
        return false;
    }
    else{

        return true;
    }

}
function submitForm(){

    if(document.getElementById("username").value.trim()==="" && document.getElementById("username").value!==null){
        mess1.css('color','red');
        mess1.html('Введите ваше ФИО.');
    }
    else if(document.getElementById("yourEmail").value.trim()==="" && document.getElementById("yourEmail").value!==null){
        mess1.css('color','red');
        mess1.html('Введите email.');
    }
    else if(checkEmail()===false){
        mess1.css('color','red');
        mess1.html('Введите правильный email.');

    }
    else if(document.getElementById("password").value.trim()==="" && document.getElementById("password").value!==null){
        mess1.css('color','red');
        mess1.html('Введите пароль.');
    }
    else if(document.getElementById("verifypassword").value.trim()==="" && document.getElementById("verifypassword").value!==null){
        mess1.css('color','red');
        mess1.html('Подтвердите пароль');
    }

    else{
        var password=pass.val();
        var confirm=verPass.val();
        if(!password===confirm){
            mess1.css('color','red');
            mess1.html('Пароль и подтверждение пароля должны совпадать.');
            return false;

        }
        return true;
    }

}
function checkEmail(){
    var email=$('#yourEmail').val();
    return (email.indexOf(".") > 2) && (email.indexOf("@") > 0);

}