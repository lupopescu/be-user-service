package be.user.service.controllers;

import be.user.service.command.UserCommand;
import be.user.service.command.UserSession;
import be.user.service.exceptions.InvalidUsernameOrPasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.security.krb5.Credentials;

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
    ResponseEntity<UserSession> userLoginPost(@Valid @RequestBody UserCommand session)  throws InvalidUsernameOrPasswordException;

}
