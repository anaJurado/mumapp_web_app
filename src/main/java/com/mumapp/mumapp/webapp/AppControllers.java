package com.mumapp.mumapp.webapp;

import com.mumapp.mumapp.user.UserComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AppControllers {

    @Autowired
    private UserComponent userComponent;

    @ModelAttribute
    public void addUserToModel(Model model) {
        boolean logged = userComponent.getLoggedUser() != null;
        model.addAttribute("logged", logged);
        if(logged) {
            model.addAttribute("admin", userComponent.getLoggedUser().getRoles().contains("ROLE_ADMIN"));
            model.addAttribute("userName",userComponent.getLoggedUser().getName());
        }
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("hideLogin", true);
        return "login";
    }

    @GetMapping("/loginerror")
    public String loginError() {
        return "loginerror";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        return "index";
    }

    @GetMapping("/register")
    public String register(Model model) {
        return "register";
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        return "profile";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        return "dashboard";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }

    @GetMapping("/error")
    public String error(Model model) {
        return "error";
    }


    // USERS

    // User info
    @GetMapping("/{id}/profile")
    public String showUserData(Model model, @PathVariable long id){}

    //User music
    @GetMapping("/{id}/music")
    public String showUserMusic(Model model, @PathVariable long id){}

    // User city
    @GetMapping("/{id}/city")
    public String showUserCity(Model model, @PathVariable long id){}

    //Popularity Rate
    @GetMapping("/{music}/{city}")
    public String showPopularityRate(Model model, @PathVariable long id){}

    // CITY
    @GetMapping("/city")
    public String showPopularityRate(Model model, @PathVariable long id){}

    // MUSIC
    @GetMapping("/music")
    public String showPopularityRate(Model model, @PathVariable long id){}


}
