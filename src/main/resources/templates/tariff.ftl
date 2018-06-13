<html xmlns="http://www.w3.org/1999/html">
<head>
<#include "imports.ftl">
    <link href="/css/sidebar.css" rel="stylesheet">
</head>
<body>
<#include "sidebar.ftl">
<#include "chat.ftl">
<div class="container">
    <div class="row">
        <div class="col-lg-8 col-lg-offset-2">
            <label>Искать по названию: <input oninput="onChange()" type="search" id="search" name="search"></label>
            <div id="container">
    <#if tariffs??>
        <#list tariffs as t>
            <#if t??>
                <h3>${t.name}</h3>
                <span>${t.price}</span>
                <p>${t.description}</p>
        <br/>
            </#if>
        </#list>
    </#if>
            </div>
        </div>
    </div>
</div>
<!-- /#sidebar-wrapper -->

</body>
<script>
    function onChange() {
        console.log("Kek")
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/tariffs/search/ajax",
            data: JSON.stringify($("#search").val()),
            success: function (result) {
                var data = result;
                $("#container").html("");

                for (var i = 0; i < data.length; i++) {
                    $("#container").append(
                            "<h3>" + data[i].name + "</h3>" +
                            "<span>" + data[i].price + "</span>" +
                            "<p>" + data[i].description + "</p>" +
                            "<br/>"

                    )
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
    }
</script>
</html>