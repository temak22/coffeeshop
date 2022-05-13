<#import "parts/common.ftl" as c>
<#include "parts/navbarAdmin.ftl">
<#include "parts/security.ftl">

<@c.page>
    <h4>Редактор пользователя</h4>
    <hr>
    <form action="/admin/user" method="post">
        <input type="hidden" value="${user.id}" name="userId">
        <br>
        <input type="text" value="${user.username}" name="username">
        <br><br>
        <#list roles as role>
            <#if name != user.username>
                <div>
                    <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
                </div>
            </#if>
        </#list>
        <br>
        <button type="submit">Save</button>
    </form>
</@c.page>