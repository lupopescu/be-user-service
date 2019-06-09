package be.user.service.converters;

import be.user.service.command.UserSessionComand;
import be.user.service.model.UserSession;
import org.springframework.core.convert.converter.Converter;

public class UserSessionToUserSessionComand implements Converter<UserSession, UserSessionComand> {
UserToUserCommand userToUserCommand=new UserToUserCommand() ;
    @Override
    public UserSessionComand convert(UserSession source) {
        UserSessionComand userSessionComand =new UserSessionComand();
        userSessionComand.setCreationTime(source.getCreationTime());
        userSessionComand.setLastAccesTime(source.getLastAccesTime());
        userSessionComand.setSessionId(source.getSessionId());
        userSessionComand.setUser(userToUserCommand.convert(source.getUser()));
        return  userSessionComand;
    }
}
