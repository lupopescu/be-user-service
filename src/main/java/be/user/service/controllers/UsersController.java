package be.user.service.controllers;

import be.user.service.command.UserCommand;

import be.user.service.exceptions.InvalidUsernameOrPasswordException;

import be.user.service.command.UserSessionComand;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

//import io.swagger.annotations.*;
//
//
//@Api(value = "users", description = "the users API")
public interface UsersController {

    @RequestMapping(value = "/users/search",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<UserCommand>> searchUsers ();

    @RequestMapping(value = "/users",
            consumes = { "application/json" },
            method = RequestMethod.POST)
     ResponseEntity<UserCommand> usersPost(@Valid @RequestBody UserCommand user) throws InvalidUsernameOrPasswordException;

    @RequestMapping(value = "/users/login",
            consumes = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<UserSessionComand> userLoginPost(@Valid @RequestBody UserCommand session)  throws InvalidUsernameOrPasswordException;


}
