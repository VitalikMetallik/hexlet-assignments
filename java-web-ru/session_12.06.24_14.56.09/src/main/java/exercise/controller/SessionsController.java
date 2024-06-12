package exercise.controller;

import java.util.Collections;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;

import static io.javalin.rendering.template.TemplateUtil.model;

public class SessionsController {

    // BEGIN
    public static void index(Context ctx) {
        var page = new MainPage(ctx.sessionAttribute("currentUser"));
        ctx.render("index.jte", model("page", page));
    }
    public static void build(Context ctx) {
        if (ctx.sessionAttribute("currentUser") == null) {
            ctx.render("build.jte");
        } else {
            ctx.redirect(NamedRoutes.rootPath());
        }
    }

    public static void login(Context ctx) {
        var name = ctx.formParam("name");
        var password = ctx.formParam("password");
        if (name != null && password != null && UsersRepository.existsByName(name)) {
            var user = UsersRepository.findByName(name);
            if (user.getPassword().equals(Security.encrypt(password))) {
                ctx.sessionAttribute("currentUser", name);
                ctx.redirect(NamedRoutes.rootPath());
            } else {
                var error = "Wrong name or password";
                var loginPage = new LoginPage(name, error);
                ctx.render("build.jte", model("loginPage", loginPage));
            }
        } else {
            var error = "Wrong name or password";
            var loginPage = new LoginPage(name, error);
            ctx.render("build.jte", model("loginPage", loginPage));
        }
    }

    public static void logout(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}