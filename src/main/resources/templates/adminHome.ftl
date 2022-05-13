<#import "parts/common.ftl" as c>
<#include "parts/navbarAdmin.ftl">

<@c.page>
    <div>
        <form method="post">
            <input type="text" name="title" placeholder="Название" required>
            <input type="number" name="cost" placeholder="Цена" required>
            <input type="text" name="description" placeholder="Описание" required>
            <button type="submit">Добавить</button>
        </form>
    </div>
    <br>
    <hr>
    <div><h4>Список позиций</h4></div>
    <hr>
    <#list items as item>
    <div>
        <b>${item.id}</b>
        <span>${item.title}</span>,
        <i>${item.cost}</i>,
        <span>${item.description}</span>
    </div>
    <#else>
        <h5>No items</h5>
    </#list>
</@c.page>
