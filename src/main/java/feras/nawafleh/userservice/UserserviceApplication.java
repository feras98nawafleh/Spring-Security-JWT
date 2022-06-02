package feras.nawafleh.userservice;

import feras.nawafleh.userservice.model.Role;
import feras.nawafleh.userservice.model.User;
import feras.nawafleh.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "feras nawafleh", "feras", "123", new ArrayList<>()));
			userService.saveUser(new User(null, "tarek nawafleh", "tarek", "123", new ArrayList<>()));
			userService.saveUser(new User(null, "mohammad nawafleh", "mohammad", "123", new ArrayList<>()));
			userService.saveUser(new User(null, "yazeed nawafleh", "yazeed", "123", new ArrayList<>()));

			userService.addRoleToUser("feras", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("tarek", "ROLE_ADMIN");
			userService.addRoleToUser("mohammad", "ROLE_MANAGER");
			userService.addRoleToUser("yazeed", "ROLE_USER");

		};
	}

}
