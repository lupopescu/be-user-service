package be.user.service.services;

import be.user.service.command.UserCommand;
<<<<<<< HEAD
=======
import be.user.service.command.UserSessionComand;
>>>>>>> work
import be.user.service.exceptions.InvalidUsernameOrPasswordException;
import be.user.service.model.User;
import be.user.service.model.UserSession;

import java.util.List;

public interface UserService {

    User findById(String id);
      UserCommand findOneByEmailAndPassword(UserCommand userCommand) throws InvalidUsernameOrPasswordException;

    UserCommand save(UserCommand userCommand) throws InvalidUsernameOrPasswordException;
    void deleteById(String idToDelete);
    List<UserCommand> getAllUsers();
<<<<<<< HEAD

=======
    UserSessionComand login(UserCommand user) throws InvalidUsernameOrPasswordException;
>>>>>>> work
}
