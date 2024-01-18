package com.example.login.Service;

import com.example.login.Dto.UserRegistrationDto;
import com.example.login.Model.Role;
import com.example.login.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

public class UserServiceImpl implements UserService{
   private UserRepository userRepository;
   @Autowired
   public BCryptPasswordEncoder passwordEncoder;
   public UserServiceImpl (UserRepository userRepository){
       super();
       this.userRepository = userRepository;
   }
    @Override
    public User save(UserRegistrationDto registrationDto) {
        User user = new User(registrationDto.getFirstName(),
                registrationDto.getLastName(), registrationDto.getEmail(),
                passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));

        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =userRepository.findByEmail(username);
        if (user ==null){
            throw new UsernameNotFoundException("Not found")
        }
        

    }
}
