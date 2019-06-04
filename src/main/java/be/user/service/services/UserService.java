package be.user.service.services;

import be.user.service.command.UserCommand;
import be.user.service.model.User;

import java.util.Set;

public interface UserService {

    User findById(String id);
    UserCommand findByEmailAndPassword(String email, String password);
    UserCommand saveUser(UserCommand userCommand);
    void deleteById(String idToDelete);
    Set<UserCommand> getAllUsers();
}
