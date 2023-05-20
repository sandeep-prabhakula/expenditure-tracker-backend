package com.sandeepprabhakula.budgettracker.service;

import com.sandeepprabhakula.budgettracker.data.User;
import com.sandeepprabhakula.budgettracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public void addNewUser(User user){

        boolean present = userRepository.findUserByEmail(user.getEmail())
                .isPresent();
        if(!present){
            String password = user.getPassword();
            user.setPassword(passwordEncoder.encode(password));
            userRepository.save(user);
        }
    }

    public void updateUser(User user){
        User currentUser = userRepository.findUserByEmail(user.getEmail())
                .orElseThrow(()->new UsernameNotFoundException("User Not found"));
        userRepository.save(currentUser);
    }

    public void deleteUser(String id){
        userRepository.findById(id);
    }
}
