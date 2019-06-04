package be.user.service.services;

import be.user.service.command.UserCommand;
import be.user.service.converters.UserCommandToUser;
import be.user.service.converters.UserToUserCommand;
import be.user.service.exceptions.NotFoundException;
import be.user.service.repository.UserRepository;
import be.user.service.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    UserCommandToUser userCommandToUser=new UserCommandToUser();
    UserToUserCommand userToUserCommand= new UserToUserCommand();

    @Override
    public User findById(String id) {
        Optional<User> user=userRepository.findById(id);

        if(user.isPresent()){
            throw new NotFoundException("User Not Found. For ID value: " + id );
        }
        else{
            return user.get();
        }
    }

    @Override
    public UserCommand findByEmailAndPassword(String email, String password) {
        return null;
    }

    @Override
    public UserCommand saveUser(UserCommand userCommand) {
        return null;
    }

    @Override
    public void deleteById(String idToDelete) {

    }

    @Override
    public Set<UserCommand> getAllUsers() {
        return null;
    }
}
