package com.tracker.ExpenseTrackerAPI.controller;

import com.tracker.ExpenseTrackerAPI.model.User;
import com.tracker.ExpenseTrackerAPI.model.dto.RegisterUser;
import com.tracker.ExpenseTrackerAPI.model.dto.SignInUser;
import com.tracker.ExpenseTrackerAPI.service.AuthenticationService;
import com.tracker.ExpenseTrackerAPI.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;


    //sign up, sign in , sign out a particular instagram user
    @PostMapping("user/register")
    public RegisterUser registerInstaUser(@RequestBody User user)
    {

        return userService.registerUser(user);
    }

    @PostMapping("user/signIn")
    public String sigInInstaUser(@RequestBody @Valid SignInUser signInInput)
    {
        return userService.signInUser(signInInput);
    }

    @DeleteMapping("user/signOut")
    public String sigOutInstaUser(String email, String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.signOutUser(email);
        }
        else {
            return "Sign out not allowed for non authenticated user.";
        }

    }

    @GetMapping("users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


}
