package be.user.service.services;

import be.user.service.model.User;
import be.user.service.model.UserSession;

public interface UserSessionService {

    UserSession findByUser(String userId);
    UserSession  saveUserSession (User user);
}
