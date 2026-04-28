package Amazon.Ecommerce.web.service;

import Amazon.Ecommerce.web.model.User;
import Amazon.Ecommerce.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
 UserRepository userRepository;
    public void addUser( User user)
    {
     userRepository.save(user);
    }
    public User getUser(int id)
    {
        Optional<User> optionalUser=userRepository.findById(id);
        if(optionalUser.isPresent())
        {
            User user=optionalUser.get();
            return user;
        }
        return null;
    }

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    // delete user

    public void deleteUser( int id)
    {

        userRepository.deleteById(id);
    }

    public  void updateUser(User user,  int id)
    {
        User oldUser = getUser(id);
        if(user!=null)
        {
            oldUser.setName(user.getName());
            oldUser.setPassword(user.getPassword());
            oldUser.setRole(user.getRole());
            userRepository.save(oldUser);
        }

    }

}
