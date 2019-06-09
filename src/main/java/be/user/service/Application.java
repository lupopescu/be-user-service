package be.user.service;

import be.user.service.command.UserSessionComand;
import be.user.service.converters.UserToUserCommand;
import be.user.service.model.User;
import be.user.service.repository.UserRepository;
import be.user.service.repository.UserSessionRepository;
import be.user.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@EnableMongoRepositories
public class Application implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public Application(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		User user=new User();
		user.setEmail("test@mail.ru");
		user.setPassword("12345645");
		user.setPhoneNumber("235678");
		userRepository.save(user);


	}
}
