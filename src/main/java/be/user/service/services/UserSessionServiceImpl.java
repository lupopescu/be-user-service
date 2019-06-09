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
    public UserSession findByUser(String userId) {

        return userSessionRepository.findByUserId(userId);
    }

    @Override
    public UserSession saveUserSession(User user) {
        UserSession userSession =userSessionRepository.findByUserId(user.getId());


            if (userSession !=null) {
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
