<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="/home">Coffeeshop</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="/home">Home</a>
                </li>
                <#if isAdmin!'false'>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/home"><u style="color: darkgray">Admin Menu</u></a>
                </li>
                </#if>
            </ul>

            <div class="navbar-text" style="margin-right: 10px">${name}</div>
            <@l.logout />
        </div>
    </div>
</nav>