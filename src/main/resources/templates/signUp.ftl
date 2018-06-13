<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <#include "imports.ftl">

    <!-- Custom CSS -->
    <link href="/css/signUp.css" rel="stylesheet">

    <link href="/css/sidebar.css" rel="stylesheet">
</head>

<body>
<#include "sidebar.ftl">
<#include "chat.ftl">
<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3 boxStyle"
             style="padding-right: 0!important;padding-left: 0!important;">
            <div class="panel-body" style="padding-right: 4px!important;padding-left: 4px!important;">
                <form method="post" name="signUpForm" id="signUpForm" enctype="multipart/form-data"
                      class="form-horizontal" action="/signUp"
                      role="form" AUTOCOMPLETE="off">
                    <fieldset class="landscape_nomargin"
                              style="min-width: 0;padding:    .35em .625em .75em!important;border: 2px solid silver!important;margin: 0 2px 10em;">
                        <legend style="border-bottom: none;width: inherit;!important;padding:inherit;" class="legend">
                            Регистрация
                        </legend>

                        <div class="form-group">
                            <div class="col-sm-12 col-md-12 col-lg-12 col-xs-12" style="text-align: right!important;">
                                <span style="color: red">*</span> <span style="font-size: 8pt;">обязательные поля</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-3 col-md-3 col-lg-4 col-xs-10 mobileLabel"></div>
                            <div class="col-sm-7 col-md-7 col-lg-6 col-xs-9 input-group mobilePad">
                                <img width="200px" height="200px" id="image"
                                     src="https://maxcdn.icons8.com/Share/icon/Users//user_male_circle_filled1600.png"
                                     onclick="onImageClick()">
                                <input type="file" name="image" accept="image/x-png,image/jpeg"
                                       style="visibility: hidden" id="load_image" onchange="readURL(this)">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                            <div class="col-sm-3 col-md-3 col-lg-4 col-xs-10 mobileLabel"
                                 style=" padding-top: 7px; text-align: right;">
                                ФИО <span style="color: red">*</span> :
                            </div>

                            <div class="col-sm-7 col-md-7 col-lg-6 col-xs-9 input-group mobilePad"
                                 style="font-weight:600;">

                                <input style="border-radius: 4px!important;" type="text" pattern="[A-Za-zА-Яа-ЯЁ ]+"
                                       class="form-control"
                                       name="name" id="name" value=${signUpForm.name!}>

                            </div>
                            <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                            <div class="col-sm-3 col-md-3 col-lg-4 col-xs-10 mobileLabel"
                                 style=" padding-top: 7px; text-align: right;">
                                Email <span style="color: red">*</span> :
                            </div>

                            <div class="col-sm-7 col-md-7 col-lg-6 col-xs-9 input-group mobilePad"
                                 style="font-weight:600;">

                                <input style="border-radius: 4px!important;" type="email" class="form-control"
                                       name="login" id="login" value=${signUpForm.login!}>

                            </div>
                            <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                            <div class="col-sm-3 col-md-3 col-lg-4 col-xs-10 mobileLabel"
                                 style=" padding-top: 7px;text-align: right;">
                                Пароль <span style="color: red">*</span> :
                            </div>

                            <div class="col-sm-7 col-md-7 col-lg-6 col-xs-9 input-group mobilePad">

                                <input type="password" name="password" id="password"
                                       class="form-control"
                                       pattern="[A-z0-9.,?/\$#;:()*&^%@]{6,}" value=${signUpForm.password!}>
                                <span class="input-group-btn"><button
                                        class="btn btn-defaultCUST" id="view_button3"
                                        style=" height: 34px;padding-left: 7px;" type="button"><span
                                        class="glyphicon glyphicon-eye-open"></span>
                             </button></span>

                            </div>
                            <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                            <div class="col-sm-3 col-md-3 col-lg-4 col-xs-10 mobileLabel"
                                 style=" padding-top: 7px;text-align: right;">
                                Подтвердите пароль <span style="color: red">*</span> :
                            </div>

                            <div class="col-sm-7 col-md-7 col-lg-6 col-xs-9 input-group mobilePad">

                                <input type="password" name="passwordRepeat" id="passwordRepeat"
                                       class="form-control" pattern="[A-z0-9.,?/\$#;:()*&^%@]{6,}"
                                       value=${signUpForm.passwordRepeat!}>
                                <span class="input-group-btn"><button
                                        class="btn btn-defaultCUST" id="view_button4"
                                        style=" height: 34px;padding-left: 7px;" type="button"><span
                                        class="glyphicon glyphicon-eye-open"></span>
                             </button></span>

                            </div>
                            <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-12 col-md-12 col-lg-12 col-xs-12" id="message"
                                 style="font-weight: bold; text-align: center;font-size: 10pt; color: red">
                                <#if error??> ${error}</#if>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                            <div class="col-sm-11 col-md-11 col-lg-11 col-xs-10" style="text-align:center;">
                                <button id="valuser" type="submit" <#--onclick="onSubmit()"-->
                                        class="btn btn-success">
                                    Регистрация
                                </button>
                            </div>

                            <div class="col-sm-1 col-md-1 col-lg-1 col-xs-1"></div>
                        </div>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    var viewButton3 = $("#view_button3");
    var viewButton4 = $("#view_button4");
    var pass = $("#password");
    var verPass = $("#passwordRepeat");

    $(document).ready(function () {
        viewButton3.bind("mousedown touchstart", function () {
            pass.attr("type", "text");
        });
        viewButton3.bind("mouseup touchend", function () {
            pass.attr("type", "password");
        });
        viewButton4.bind("mousedown touchstart", function () {
            verPass.attr("type", "text");
        });
        viewButton4.bind("mouseup touchend", function () {
            verPass.attr("type", "password")
        })
    });

    /*function onSubmit() {
        var form = {};
        form["name"] = $("#name").val();
        form["login"] = $("#login").val();
        form["password"] = $("#password").val();
        form["passwordRepeat"] = $("#passwordRepeat").val();
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/signUp/ajax",
            data: JSON.stringify(form),
            success: function (result) {
                console.log(result);
                var messageBox = $("#message").html("");
                if (result !== "none") {
                    messageBox.append(result)
                }
                else {
                    $("#signUpForm").submit();
                }
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
    }*/

    function onImageClick() {
        $("#load_image").click()
    }

    /*function onImageLoaded() {
        var image = new FormData();
        image.append("image", load_image.files[0]);
        $.ajax({
            type: "POST",
            url: "/image-load",
            data: image,
            dataType: 'text',
            processData: false,
            contentType: false,
            cache: false,
            success: function (result) {
                console.log(result);
                if (result !== "none") {
                    $("#image").attr("src", "/image/" + result)
                }
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
        });*/
    }

    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                $("#image")
                        .attr('src', e.target.result);
            };

            reader.readAsDataURL(input.files[0]);
        }
    }
</script>
</html>
