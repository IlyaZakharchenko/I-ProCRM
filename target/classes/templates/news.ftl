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
            <form id="form" method="post" action="/news">
                <select oninput="onChange()" name="select">
                    <option <#if select?? && select == "Все">selected</#if> name="all">Все</option>
                    <option <#if select?? && select == "Сегодняшние">selected</#if> name="today">Сегодняшние</option>
                </select>
            </form>
    <#if news??>
        <#list news as n>
            <#if n??>
                <h3>${n.header}</h3>
                <p>${n.context}</p>
                <span>${n.date}</span>
        <br/>
            </#if>
        </#list>
    </#if>
        </div>
    </div>
</div>
<!-- /#sidebar-wrapper -->

</body>
<script>
    function onChange() {
        $("#form").submit();
        console.log("Submit")
    }
</script>
</html>