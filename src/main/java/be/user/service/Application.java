package be.user.service;

import be.user.service.model.User;
import be.user.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

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
		userRepository.findAll().forEach(System.out::println);
	}
}
