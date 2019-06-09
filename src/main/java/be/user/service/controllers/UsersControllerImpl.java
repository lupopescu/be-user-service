package be.user.service.controllers;

import be.user.service.command.UserCommand;

import be.user.service.exceptions.InvalidUsernameOrPasswordException;

import be.user.service.command.UserSessionComand;
import be.user.service.exceptions.InvalidUsernameOrPasswordException;
import be.user.service.model.User;
import be.user.service.model.UserSession;
import be.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UsersControllerImpl implements UsersController{

    @Autowired
   private UserService userService;



    public UsersControllerImpl(UserService userService) {
        this.userService = userService;

    }

    public ResponseEntity<List<UserCommand>> searchUsers(){

        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Override
    public ResponseEntity<UserCommand> usersPost(@Valid UserCommand user) throws InvalidUsernameOrPasswordException {

        return ResponseEntity.ok(userService.save(user));
    }


    @Override
    public ResponseEntity<UserSessionComand> userLoginPost(@Valid UserCommand user)  throws InvalidUsernameOrPasswordException{
        return ResponseEntity.ok(userService.login(user));
    }

}
