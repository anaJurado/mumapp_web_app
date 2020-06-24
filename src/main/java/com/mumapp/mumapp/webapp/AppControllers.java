package com.mumapp.mumapp.webapp;

import com.mumapp.mumapp.user.UserComponent;
import com.mumapp.mumapp.user.UserRepository;
import com.mumapp.mumapp.city.CityService;
import com.mumapp.mumapp.music.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import com.mumapp.mumapp.user.User;
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

    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin";
    }

    @GetMapping("/error")
    public String error(Model model) {
        return "error";
    }

    // PROFILE VIEW
    @GetMapping("/profile")
    public String profileView(Model model){
        Long id = userComponent.getLoggedUser().getId();

        //USER INFO
        Optional<User> user = userRepository.findById(id);

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

    // DASHBOARD VIEW
    @GetMapping("/dashboard")
    public String dashboardView(Model model){
        Long id;
        id = userComponent.getLoggedUser().getId();

        //USER INFO
        Optional<User> user;
        user = userRepository.findById(id);

        user.ifPresent(value -> {
            model.addAttribute("user", value);
            model.addAttribute("userMusic", value.getMusicSet());
            model.addAttribute("userCity", value.getCitySet());
        });
        //MUSIC INFO
        model.addAttribute("allMusic", musicService.findAll());

        //CITY INFO
        model.addAttribute("allCity", cityService.findAll());

        //MUSIC CITY POPULARITY RATE
        model.addAttribute("popRate", musicService.findAll());

        return "dashboard";
    }
}
