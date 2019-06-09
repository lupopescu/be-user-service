package be.user.service.repository;

import be.user.service.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
    User findOneByEmailAndPassword(String email, String password);
    List<User> findAll();

}
