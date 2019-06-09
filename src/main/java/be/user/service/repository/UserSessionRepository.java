package be.user.service.repository;

import be.user.service.model.User;
import be.user.service.model.UserSession;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface UserSessionRepository extends CrudRepository<UserSession, User> {

//    UserSession saveUserSession(UserSession user);
   UserSession findByUserId(String userId);
}
