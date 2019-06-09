package be.user.service.controllers;

import be.user.service.command.UserCommand;
import be.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UsersControllerImpl implements UsersController{

    @Autowired
    UserService userService;

    public UsersControllerImpl(UserService userService) {

        this.userService = userService;
    }


    public ResponseEntity<List<UserCommand>> searchUsers(){

        return ResponseEntity.ok(userService.getAllUsers());
    }

    @Override
    public ResponseEntity<UserCommand> usersPost(@Valid UserCommand user) {
        return ResponseEntity.ok(userService.save(user));
    }
}
