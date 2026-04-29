package Amazon.Ecommerce.web.controller;

import Amazon.Ecommerce.web.model.User;
import Amazon.Ecommerce.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class Controller {

    @Autowired
    UserService userService;

    // Add User
    @PostMapping("/")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    // Get User by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    // Get All Users
    @GetMapping("/")
    public ResponseEntity<?> getAllUsers() {
        return userService.getAllUsers();
    }

    // Delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    // Update User
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable int id) {
        return userService.updateUser(user, id);
    }
}