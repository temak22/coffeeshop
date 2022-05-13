<#import "parts/common.ftl" as c>
<#include "parts/navbarUser.ftl">

<@c.page>
    <div><h4>Товары</h4></div>
    <hr>
    <#list items as item>
        <div class="col-sm-6">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title"><span>${item.title}</span></h5>
                    <p class="card-text"><i>Price: ${item.cost}</i><br><span>${item.description}</span></p>
                </div>
            </div>
        </div>
        <br>
    <#else>
        <h4>No items</h4>
    </#list>
</@c.page>