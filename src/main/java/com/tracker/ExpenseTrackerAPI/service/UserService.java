package com.tracker.ExpenseTrackerAPI.service;

import com.tracker.ExpenseTrackerAPI.model.AuthenticationToken;
import com.tracker.ExpenseTrackerAPI.model.User;
import com.tracker.ExpenseTrackerAPI.model.dto.RegisterUser;
import com.tracker.ExpenseTrackerAPI.model.dto.SignInUser;
import com.tracker.ExpenseTrackerAPI.repository.IUserRepo;
import com.tracker.ExpenseTrackerAPI.service.utility.EmailUtility;
import com.tracker.ExpenseTrackerAPI.service.utility.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;

    @Autowired
    AuthenticationService authenticationService;

    public RegisterUser registerUser(User user) {

        boolean registerStatus = true;
        String registerStatusMessage = null;

        String newEmail = user.getUserEmail();

        if(newEmail == null)
        {
            registerStatusMessage = "Invalid email";
            registerStatus = false;
            return new RegisterUser(registerStatus,registerStatusMessage);
        }

        //check if this user email already exists ??
        User existingUser = userRepo.findFirstByUserEmail(newEmail);

        if(existingUser != null)
        {
            registerStatusMessage = "Email already registered!!!";
            registerStatus = false;
            return new RegisterUser(registerStatus,registerStatusMessage);
        }

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(user.getUserPassword());

            //saveAppointment the user with the new encrypted password

            user.setUserPassword(encryptedPassword);
            userRepo.save(user);

            return new RegisterUser(registerStatus, "User registered successfully!!!");
        }
        catch(Exception e)
        {
            registerStatusMessage = "Internal error occurred during sign up";
            registerStatus = false;
            return new RegisterUser(registerStatus,registerStatusMessage);
        }
    }


    public String signInUser(SignInUser signInInput) {


        String signInStatusMessage = null;

        String signInEmail = signInInput.getEmail();

        if(signInEmail == null)
        {
            signInStatusMessage = "Invalid email";
            return signInStatusMessage;


        }

        //check if this user email already exists ??
        User existingUser = userRepo.findFirstByUserEmail(signInEmail);

        if(existingUser == null)
        {
            signInStatusMessage = "Email not registered!!!";
            return signInStatusMessage;

        }

        //match passwords :

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEncrypter.encryptPassword(signInInput.getPassword());
            if(existingUser.getUserPassword().equals(encryptedPassword))
            {
                //session should be created since password matched and user id is valid
                AuthenticationToken authToken  = new AuthenticationToken(existingUser);
                authenticationService.saveAuthToken(authToken);

                EmailUtility.sendEmail("mainakgh1@gmail.com","email testing",authToken.getTokenValue());
                return "Token sent to your email";
            }
            else {
                signInStatusMessage = "Invalid credentials!!!";
                return signInStatusMessage;
            }
        }
        catch(Exception e)
        {
            signInStatusMessage = "Internal error occurred during sign in";
            return signInStatusMessage;
        }

    }


    public String signOutUser(String email) {

        User user = userRepo.findFirstByUserEmail(email);
        AuthenticationToken token = authenticationService.findFirstByUser(user);
        authenticationService.removeToken(token);
        return "User Signed out successfully";
    }
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
