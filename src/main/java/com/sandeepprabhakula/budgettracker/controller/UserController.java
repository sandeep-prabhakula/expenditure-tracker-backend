package com.sandeepprabhakula.budgettracker.controller;

import com.sandeepprabhakula.budgettracker.data.User;
import com.sandeepprabhakula.budgettracker.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public void addNewUser(@RequestBody User user){
        userService.addNewUser(user);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    @DeleteMapping("/delete-account/{id}")
    public void deleteUser(@PathVariable("id") String id){
        userService.deleteUser(id);
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @PutMapping("/update-user")
    public ResponseEntity<String> updateUser(@RequestBody User user, Authentication auth){
        if(auth.getName().equals(user.getEmail()))userService.updateUser(user);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Access Denied");
    }
}
