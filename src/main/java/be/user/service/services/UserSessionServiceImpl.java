package be.user.service.services;

import be.user.service.model.User;
import be.user.service.model.UserSession;
import be.user.service.repository.UserSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserSessionServiceImpl implements UserSessionService {


    @Autowired
    UserSessionRepository userSessionRepository;

    public UserSessionServiceImpl(UserSessionRepository userSessionRepository) {
        this.userSessionRepository = userSessionRepository;
    }

    @Override
    public UserSession findByUser(User user) {

        return userSessionRepository.findByUser(user);
    }

    @Override
    public UserSession saveUserSession(User user) {
        UserSession userSession =userSessionRepository.findByUser(user);


            if (!userSession.equals(null)) {
                userSession.setCreationTime(System.currentTimeMillis());
                userSession.setLastAccesTime(System.currentTimeMillis());

            }else{
                userSession=new UserSession();
                userSession.setCreationTime(System.currentTimeMillis());
                userSession.setLastAccesTime(System.currentTimeMillis());
                userSession.setUser(user);
            }


        return userSessionRepository.save(userSession);
    }
}
