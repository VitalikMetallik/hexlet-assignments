@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(content = @`
    @if(page.getName() == null)
        <h3>
            <a href="${exercise.util.NamedRoutes.buildSessionPath()}">Войти</a>
        </h3>
    @else
        <p>${String.valueOf(page.getName())}</p>
        <form action="${NamedRoutes.logoutPath()}" method="post">
            <input type="submit" value="Exit" />
        </form>
    @endif
`)