<#assign
    known = Session.SPRING_SECURITY_CONTEXT??
>

<#if known>
    <#assign
        userThis = Session.SPRING_SECURITY_CONTEXT.authentication.principal
        name = userThis.getUsername()
        authorities = userThis.getAuthorities()?size
    >
    <#if authorities == 2>
        <#assign
            isAdmin = true
        >
    <#else>
        <#assign
            isAdmin = false
        >
    </#if>
<#else>
    <#assign
        name = "unknown"
        isAdmin = false
    >
</#if>