<#import "parts/common.ftl" as c>
<#include "parts/navbarAdmin.ftl">

<@c.page>
    <h4>Список пользователей</h4>
    <br>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Имя</th>
            <th scope="col">Роль</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td>
                    <#list user.roles as role>
                        ${role}<#sep>,
                    </#list>
                </td>
                <td>
                    <a href="/admin/user/${user.id}">edit</a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>