package be.user.service.converters;

import be.user.service.command.UserCommand;
import be.user.service.model.User;
import org.springframework.core.convert.converter.Converter;

public class UserCommandToUser implements Converter<UserCommand, User> {
    @Override
    public User convert(UserCommand source) {
        User user=new User();
        user.setEmail(source.getEmail());
        user.setPhoneNumber(source.getPhoneNumber());
        user.setPassword(source.getPassword());
        return user;
    }
}
