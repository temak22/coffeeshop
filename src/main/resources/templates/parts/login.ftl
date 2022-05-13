<#macro login path>
    <form action="${path}" method="post">
        <div class="form-group row">
            <label for="inputEmail" class="col-sm-2 col-form-label"> User Name:</label>
            <div class="col-sm-10">
                <input class="form-control" id="inputEmail" type="text" name="username" placeholder="User name"/>
            </div>
        </div>
        <br>
        <div class="form-group row">
            <label for="inputPassword" class="col-sm-2 col-form-label"> Password:</label>
            <div class="col-sm-10">
                <input class="form-control" id="inputPassword" type="password" name="password" placeholder="Password"/>
            </div>
        </div>
        <br>
        <button type="submit" class="btn btn-primary">Sign in</button>
        <br>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post" style="margin-bottom: 0px">
        <button type="submit" class="btn btn-primary">Sign out</button>
    </form>
</#macro>