package Amazon.Ecommerce.web.controller;

import Amazon.Ecommerce.web.model.User;
import Amazon.Ecommerce.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/public")
public class PublicController {

    @Autowired
    UserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String RegisterPage(Model model)
    {
        model.addAttribute("user",new User());
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.addUser(user);
        return "login";
    }
    @GetMapping("/home")
    public String homePage(Model  model)
    {
        ArrayList<String> listname=new ArrayList<>();
        listname.add("yogendra");
        listname.add("shiv");
        listname.add("ajit");

        model.addAttribute("listname",listname);
        model.addAttribute("a",10);
        model.addAttribute("b",20);
        return "home";
    }
    @GetMapping("/login")
    public String LoginPage(Model model)
    {
        model.addAttribute("user",new User());
        return "home";
    }
}

