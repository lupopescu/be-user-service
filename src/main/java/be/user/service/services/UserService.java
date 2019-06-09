package be.user.service.services;

import be.user.service.command.UserCommand;
import be.user.service.command.UserSession;
import be.user.service.exceptions.InvalidUsernameOrPasswordException;
import be.user.service.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {

    User findById(String id);
      UserCommand findOneByEmailAndPassword(UserCommand userCommand) throws InvalidUsernameOrPasswordException;

    UserCommand save(UserCommand userCommand) throws InvalidUsernameOrPasswordException;
    void deleteById(String idToDelete);
    List<UserCommand> getAllUsers();
    UserSession login(UserCommand user) throws InvalidUsernameOrPasswordException;
}
