package Amazon.Ecommerce.web.controller;

import Amazon.Ecommerce.web.model.User;
import Amazon.Ecommerce.web.repository.UserRepository;
import Amazon.Ecommerce.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class Controller {
    @Autowired
    UserService userService;
    //Add a new User
    @PostMapping("/")
    public void addUser(@RequestBody User user)
    {
       userService.addUser(user);
    }

    // Fetch User
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id)
    {
        return userService.getUser(id);
    }

    //Fetch All user
    @GetMapping("/")
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    //Deleting th User
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) { userService.deleteUser(id); }

    //Updating th User
    @PutMapping("/{id}")
    public  void updateUser(@RequestBody   User user, @PathVariable int id) { userService.updateUser(user,id); }

}
