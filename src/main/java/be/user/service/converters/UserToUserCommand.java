package be.user.service.converters;

import be.user.service.command.UserCommand;
import be.user.service.model.User;
import org.springframework.core.convert.converter.Converter;

public class UserToUserCommand implements Converter<User, UserCommand> {

    @Override
    public UserCommand convert(User source) {

        UserCommand userCommand=new UserCommand();
        userCommand.setId(source.getId());
        userCommand.setEmail(source.getEmail());
        userCommand.setPassword(source.getPassword());
        userCommand.setPhoneNumber(source.getPhoneNumber());
        return userCommand;
    }
}
