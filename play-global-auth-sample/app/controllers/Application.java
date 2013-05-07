package controllers;

import annotations.SkipAuth;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
    public static Result index() {
    	System.out.println("index");
        return ok(index.render("Your new application is ready."));
    }
    
    @SkipAuth
    public static Result login() {
    	System.out.println("login");
        return ok(index.render("Welcom to our site."));    	
    }
  
}
