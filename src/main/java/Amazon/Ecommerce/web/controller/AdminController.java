package Amazon.Ecommerce.web.controller;

import Amazon.Ecommerce.web.model.User;
import Amazon.Ecommerce.web.repository.UserRepository;
import Amazon.Ecommerce.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    // Add User
    @GetMapping("/dashboard")
    public String adminDashboard(Model model) {
        List<User> users =userService.getAllUsers();
        model.addAttribute("users",users);
        return "admindashboard";
    }

   /* // Get All Users
    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }*/

    // Get User by ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    // Delete User
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id)
    {
        User user = userService.getUser(id);
        if(user!=null)
        {
            userService.deleteUser(id);
        }
        return "redirect:/admin/dashboard";
    }

    // Update User
    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable int id,Model model)
    {
       User user = userService.getUser(id);
       model.addAttribute("user",user);
        return "editUser";
    }
    @PostMapping("/update")
    public String updateUser(@ModelAttribute User user)
    {
        userRepository.save(user);
        return "redirect:/admin/dashboard";
    }

}