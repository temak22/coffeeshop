<#import "parts/login.ftl" as l>
<#import "parts/common.ftl" as c>

<@c.page>
    <div class="mb-2"><h5>Вход в систему</h5></div>
    <hr>
    <div class="mb-2"><@l.login "/login" /></div>
    <a href="/registration">Зарегистрироваться</a>
</@c.page>