package be.user.service.controllers;

import be.user.service.command.UserCommand;
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
     ResponseEntity<UserCommand> usersPost(@Valid @RequestBody UserCommand user);
}
