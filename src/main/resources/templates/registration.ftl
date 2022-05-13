<#import "parts/login.ftl" as l>
<#import "parts/common.ftl" as c>

<@c.page>
    <div class="mb-2"><h5>Добавление пользователя</h5></div>
    <hr>
    ${message!' '}
    <@l.login "/registration" />
</@c.page>