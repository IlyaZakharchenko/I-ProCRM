<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <#include "imports.ftl">
    <link href="/css/signIn.css" rel="stylesheet" id="signUp-css">
    <link href="/css/sidebar.css" rel="stylesheet">

    <!-- Firebase -->
    <script src="https://www.gstatic.com/firebasejs/5.0.4/firebase-app.js"></script>
    <script src="https://www.gstatic.com/firebasejs/5.0.4/firebase-auth.js"></script>
    <script>
        // Initialize Firebase
        var config = {
            apiKey: "AIzaSyD7SpcXuGWUqlQVNVqD-MHx1Fl7c6EZwsg",
            authDomain: "i-pro-crm.firebaseapp.com",
            databaseURL: "https://i-pro-crm.firebaseio.com",
            projectId: "i-pro-crm",
            storageBucket: "i-pro-crm.appspot.com",
            messagingSenderId: "1000494616448"
        };
        firebase.initializeApp(config);
    </script>

</head>
<body>
<#include "sidebar.ftl">
<#include "chat.ftl">
<!-- Where all the magic happens -->
<!-- LOGIN FORM -->
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Войти</h3>
                </div>
                <div class="panel-body">
                    <div id="message" style="color: red; text-align: center;"><#if error??>${error}</#if></div>
                    <form accept-charset="UTF-8" id="singInForm" name="singInForm" role="form" method="post" action="/login">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="Логин" name="login" id="login" type="text">
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Пароль" name="password" id="password" type="password"
                                       value="">
                            </div>
                            <div class="checkbox">
                                <input name="remember_me" type="checkbox" id="remember_me">
                                <label for="remember_me">Запомнить меня</label>
                            </div>
                            <input id="button_sign_in" class="btn btn-lg btn-success btn-block" type="submit" value="Войти">
                        </fieldset>
                    </form>

                    <hr/>
                    <div style="text-align: center;"><h4>ИЛИ</h4></div>
                    <form action="/connect/facebook" method="POST">
                        <input type="hidden" name="scope" value="public_profile"/>
                        <input class="btn btn-lg btn-f btn-block" type="button"
                               value="Войти через Facebook" onclick="signInFacebook()">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    var displayName;
    var email;
    var photoURL;
    var uid;

    function signInFacebook() {
        var provider = new firebase.auth.FacebookAuthProvider();
        provider.addScope('public_profile');
        firebase.auth().useDeviceLanguage();
        provider.setCustomParameters({
            'display': 'popup'
        });
        firebase.auth().signInWithPopup(provider).then(function (result) {
            // This gives you a Facebook Access Token. You can use it to access the Facebook API.
            var token = result.credential.accessToken;
            // The signed-in user info.
            var user = result.user;
        }).catch(function (error) {
            // Handle Errors here.
            var errorCode = error.code;
            var errorMessage = error.message;
            // The email of the user's account used.
            var email = error.email;
            // The firebase.auth.AuthCredential type that was used.
            var credential = error.credential;
            // ...
        });

        firebase.auth().onAuthStateChanged(function(user) {
            if (user) {
                displayName = user.displayName;
                email = user.email;
                photoURL = user.photoURL;
                uid = user.uid;
                signIn();
            }
        });
    }

    function signIn() {
        var form = {};
        form["displayName"] = displayName;
        form["email"] = email;
        form["uid"] = uid;
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/signIn/facebook",
            data: JSON.stringify(form),
            success: function (result) {
                $("#password").val(result.uid);
                $("#login").val(result.email);
                $("#singInForm").submit();
                console.log("Submit");
            },
            error: function (jqXHR, exception) {
                if (jqXHR.status === 0) {
                    alert('No connection.\n Verify Network.');
                } else if (jqXHR.status === 404) {
                    alert('[404] Page not found.');
                } else if (jqXHR.status === 500) {
                    alert('[500] Internal server error.');
                } else if (exception === 'parsererror') {
                    alert('Requested JSON parse failed.');
                } else if (exception === 'timeout') {
                    alert('Time out error.');
                } else if (exception === 'abort') {
                    alert('Ajax request aborted.');
                } else {
                    alert('Unknown Error.\n' + jqXHR.responseText);
                }
            }
        });
    }
</script>
</html>