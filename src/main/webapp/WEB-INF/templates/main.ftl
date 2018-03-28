<html>
<body>
<#list clients as c>
    <h4><#if c.name??>${c.name}</#if></h4>
</#list>
</body>
</html>