@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage
@param LoginPage loginPage

@template.layout.page(content = @`
    <div>
        <form action="${NamedRoutes.loginPath()}" method="post">
            @if(loginPage != null && !loginPage.getError().isEmpty())
                <ul>
                    <li>${loginPage.getError()}</li>
                </ul>
            @endif
            <div>
                <label>
                    Имя
                    <input type="text" name="name" value="${loginPage != null ? loginPage.getName() : ""}"/>
                </label>
            </div>

            <div>
                <label>
                    Пароль
                    <input type="password" name="password" />
                </label>
            </div>
            <input type="submit" value="Enter">
        </form>
    </div>
`)