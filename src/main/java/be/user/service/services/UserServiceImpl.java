package be.user.service.services;

import be.user.service.command.UserCommand;
import be.user.service.command.UserSessionComand;
import be.user.service.converters.UserCommandToUser;
import be.user.service.converters.UserSessionToUserSessionComand;
import be.user.service.converters.UserToUserCommand;
import be.user.service.exceptions.InvalidUsernameOrPasswordException;
import be.user.service.exceptions.NotFoundException;
import be.user.service.model.UserSession;
import be.user.service.repository.UserRepository;
import be.user.service.model.User;
import be.user.service.repository.UserSessionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
   private final UserSessionService userSessionService;

    public UserServiceImpl(UserRepository userRepository, UserSessionService userSessionService) {
        this.userRepository = userRepository;
        this.userSessionService = userSessionService;
    }

    private final UserCommandToUser userCommandToUser = new UserCommandToUser();
    private final UserToUserCommand userToUserCommand = new UserToUserCommand();
    private final UserSessionToUserSessionComand userSessionToUserSessionComand=new UserSessionToUserSessionComand();

    @Override
    public User findById(String id) {

        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent()) {
            throw new NotFoundException("User Not Found. For ID value: " + id);
        } else {
            return user.get();
        }
    }

    @Override
    public UserCommand findOneByEmailAndPassword(UserCommand userCommand) throws InvalidUsernameOrPasswordException {

        User userInDB = userRepository.findByEmail(userCommand.getEmail());

        if (userCommand.getEmail().equals(userInDB.getEmail())) {
            if (userCommand.getPassword().equals(userInDB.getPassword())) {

                return userToUserCommand.convert(userInDB);
            } else {
                throw new InvalidUsernameOrPasswordException("Invalid user email or password exception");
            }
        } else {
            throw new InvalidUsernameOrPasswordException("Invalid user email or password exception");
        }
    }


    @Override
    public UserCommand save(UserCommand userCommand) throws InvalidUsernameOrPasswordException {

        User userInDB = userRepository.findByEmail(userCommand.getEmail());
        if (userInDB == null) {
            User user = (userRepository.save(userCommandToUser.convert(userCommand)));
            return userToUserCommand.convert(user);
        } else {
            throw new InvalidUsernameOrPasswordException("This email is used by another user");
        }


    }

    @Override
    public void deleteById(String idToDelete) {

        userRepository.deleteById(idToDelete);

    }

    @Override
    public List<UserCommand> getAllUsers() {

        return userRepository.findAll().stream()
                .map(a -> userToUserCommand.convert(a))
                .collect(Collectors.toList());
    }

    @Override
    public UserSessionComand login(UserCommand userCommand) throws InvalidUsernameOrPasswordException {

        UserSession userSession ;
        User user = userCommandToUser.convert(findOneByEmailAndPassword( userCommand));

     if (!user.equals(null)) {
         userSession= userSessionService.saveUserSession(user);
         return userSessionToUserSessionComand.convert(userSession);
     }

        return new UserSessionComand();
    }
}
