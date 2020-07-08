package com.mumapp.mumapp.webapp;

import com.mumapp.mumapp.city.City;
import com.mumapp.mumapp.imageservice.ImageService;
import com.mumapp.mumapp.music.Music;
import com.mumapp.mumapp.user.UserComponent;
import com.mumapp.mumapp.user.UserRepository;
import com.mumapp.mumapp.city.CityService;
import com.mumapp.mumapp.music.MusicService;
import com.mumapp.mumapp.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.mumapp.mumapp.user.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@Controller
public class AppControllers {

    @Autowired
    private UserComponent userComponent;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private MusicService musicService;

    @Autowired
    private CityService cityService;

    @Autowired
    private ImageService imgService;

    @ModelAttribute
    public void addUserToModel(Model model) {
        boolean logged = userComponent.getLoggedUser() != null;
        model.addAttribute("logged", logged);
        if (logged) {
            model.addAttribute("admin", userComponent.getLoggedUser().getRoles().contains("ROLE_ADMIN"));
            model.addAttribute("userName", userComponent.getLoggedUser().getName());
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

    @GetMapping("/logout")
    public String logout(Model model) {
        return "index";
    }

    @GetMapping("/error")
    public String error(Model model) {
        return "error";
    }

    @GetMapping("/loginerror")
    public String loginError() {
        return "loginerror";
    }


    // ADMIN VIEW
    @GetMapping("/admin")
    public String adminView(Model model) {

        Long id = userComponent.getLoggedUser().getId();

        //USER INFO
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
        }

        // ALL USERS
        model.addAttribute("allUser", userRepository.findAll());

        //MUSIC INFO
        model.addAttribute("allMusic", musicService.findAll());

        //CITY INFO
        model.addAttribute("allCity", cityService.findAll());

        return "admin";
    }


    // ADMIN VIEW - USER
    @GetMapping("/newUser")
    public String newUser(Model model) {
        return "updateUserForm";
    }

    @GetMapping("/user/{id}")
    public String updateUser(Model model, @PathVariable long id) {

        Optional<User> user = Optional.ofNullable(userRepository.findById(id));
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
        }
        return "updateUserForm";
    }

    @PostMapping("/saveUser")
    public String saveUser(Model model, User user, HttpServletRequest request) {

        System.out.println("holaaaaaa");
        // IF NEW USER
        if (user.getId() == Long.valueOf(0)) {
            String firstName = user.getFirstName();
            String lastName = user.getLastName();
            String name = user.getName();
            String email = user.getEmail();
            String pass = user.getPasswordHash();
            userRepository.save(new User(firstName, lastName, name, email, pass, "ROLE_USER"));
        } else {

            int x = 5;

/*            Music someArray=[];
            Set<Music> myMusicSet = new HashSet<>(Arrays.asList(someArray));*/

            /*userRepository.save(user);*/



            /*
            Long updated_user_id = user.getId();
            Optional<User> updated_user = userRepository.findById(updated_user_id);
            Set<Music> music_set = userRepository.findById(updated_user_id).getMusicSet();
            Set<City> city_set = userRepository.findById(updated_user_id).getCitySet();
            List<String> roles = userRepository.findById(updated_user_id).getRoles();

            user.setMusicSet(music_set);
            user.setCitySet(city_set);
            user.setRoles(roles);

            Set<Music> updated_user_music_set = user.getMusicSet();
            Set<City> updated_user_city_set = user.getCitySet();
            Model a = model;
            */

        }

        return "info_updated";
    }

    @PostMapping("/saveUserImage")
    public String saveUserImage(Model model, User user,
                                @RequestParam MultipartFile imageFile) throws IOException {

        user.setImage(true);
        userRepository.save(user);

        Long id = user.getId();
        imgService.saveImage("users", id, imageFile);

        return "profile_updated";

    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(Model model, @PathVariable long id) {

        userService.deleteUserById(id);

        return "info_updated";
    }


    // ADMIN VIEW - MUSIC
    @GetMapping("/newMusic")
    public String newMusic(Model model) {
        return "updateMusicForm";
    }

    @PostMapping("/saveMusic")
    public String saveMusic(Model model, Music music) {

        musicService.save(music);

        return "info_updated";
    }

    @GetMapping("/music/{id}")
    public String updateMusic(Model model, @PathVariable long id) {

        Optional<Music> music = (musicService.findById(id));
        if(music.isPresent()) {
            model.addAttribute("music", music.get());
        }
        return "updateMusicForm";
    }

    @GetMapping("/deleteMusic/{id}")
    public String deleteMusic(Model model, @PathVariable long id) {

        musicService.deleteMusicById(id);

        return "info_updated";
    }


    // ADMIN VIEW - CITY
    @GetMapping("/newCity")
    public String newCity(Model model) {
        return "updateCityForm";
    }

    @PostMapping("/saveCity")
    public String saveCity(Model model, City city) {

        cityService.save(city);

        return "info_updated";
    }

    @GetMapping("/city/{id}")
    public String updateCity(Model model, @PathVariable long id) {

        Optional<City> city = (cityService.findById(id));
        if(city.isPresent()) {
            model.addAttribute("city", city.get());
        }
        return "updateCityForm";
    }

    @GetMapping("/deleteCity/{id}")
    public String deleteCity(Model model, @PathVariable long id) {

        cityService.deleteCityById(id);

        return "info_updated";
    }


    @GetMapping("/getData")
    public String getData(Model model) {

        musicService.getData();

        return "profile_updated";
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
