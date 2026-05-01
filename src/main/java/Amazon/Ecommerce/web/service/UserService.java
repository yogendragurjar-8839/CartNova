    package Amazon.Ecommerce.web.service;

    import Amazon.Ecommerce.web.model.User;
    import Amazon.Ecommerce.web.repository.UserRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.Optional;

    @Service
    public class UserService {

        @Autowired
        UserRepository userRepository;

        // Add User
        public ResponseEntity<?> addUser(User user) {
            if (user != null) {
                userRepository.save(user);
                System.out.println("User added");
                return new ResponseEntity<>("User added successfully", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("User Not Found", HttpStatus.BAD_REQUEST);
            }
        }

        // Get User by ID
        public ResponseEntity<?> getUser(int id) {
            Optional<User> optionalUser = userRepository.findById(id);

            if (optionalUser.isPresent()) {
                return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
            }
        }

        // Get All Users
        public ResponseEntity<?> getAllUsers() {
            List<User> users = userRepository.findAll();
            return new ResponseEntity<>(users, HttpStatus.OK);
        }

        // Delete User
        public ResponseEntity<?> deleteUser(int id) {
            Optional<User> optionalUser = userRepository.findById(id);

            if (optionalUser.isPresent()) {
                userRepository.deleteById(id);
                return new ResponseEntity<>("User Deleted Successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
            }
        }

        // Update User
        public ResponseEntity<?> updateUser(User user, int id) {
            Optional<User> optionalUser = userRepository.findById(id);

            if (optionalUser.isPresent() && user != null) {
                User oldUser = optionalUser.get();

                oldUser.setUsername((user.getUsername()));
                oldUser.setPassword(user.getPassword());
                oldUser.setRole(user.getRole());

                userRepository.save(oldUser);
                return new ResponseEntity<>("User Updated Successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
            }
        }
    }