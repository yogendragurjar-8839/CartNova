package Amazon.Ecommerce.web.service;

import Amazon.Ecommerce.web.model.User;
import Amazon.Ecommerce.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserDetailServiceImpl implements  UserDetailsService {
    @Autowired
   private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      Optional<User> user1= userRepository.findByUsername(username);
      if(user1.isPresent()){
          User user=user1.get();
          return new org.springframework.security.core.userdetails.User(
                  user.getUsername(),
                  user.getPassword(),
          List.of(new SimpleGrantedAuthority(user.getRole()))
          );
      }
      else {
          throw new UsernameNotFoundException("User Not Found");
      }
      }

    }