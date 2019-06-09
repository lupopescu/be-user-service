package be.user.service.repository;

import be.user.service.command.UserSession;
import be.user.service.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserSessionRepository extends CrudRepository<UserSession, String> {

    UserSession saveUserSession(User user);
    UserSession findByUser(User user);
}
