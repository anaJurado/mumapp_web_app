package com.mumapp.mumapp.webapp;

import com.mumapp.mumapp.music.Music;
import com.mumapp.mumapp.city.City;
import com.mumapp.mumapp.city.CityService;
import com.mumapp.mumapp.music.MusicService;
import com.mumapp.mumapp.user.User;
import com.mumapp.mumapp.user.UserComponent;
import com.mumapp.mumapp.user.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class AppControllers {

    @Autowired
    private UserComponent userComponent;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MusicService musicService;

    @Autowired
    private CityService cityService;

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

/*
    @GetMapping("/profile")
    public String profile(Model model) {
        return "profile";
    }
*/

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
    @GetMapping("/{name}/profile")
    public String showUserInfo(Model model, @PathVariable String name){

        //USER INFO
        Optional<User> user = Optional.ofNullable(userRepository.findByName(name));

        if(user.isPresent()) {
            model.addAttribute("user", user.get());
            model.addAttribute("userMusic", user.get().getMusicSet());
            model.addAttribute("userCity", user.get().getCitySet());
        }

        //MUSIC INFO
        model.addAttribute("allMusic", musicService.findAll());

        //CITY INFO
        model.addAttribute("allCity", cityService.findAll());

        return "profile";
    }


    /*
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
*/
}
