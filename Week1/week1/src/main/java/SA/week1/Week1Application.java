package SA.week1;

import SA.week1.models.User;
import SA.week1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Week1Application {
	@Autowired
	private UserRepository userRepository;


	public static void main(String[] args) {

		SpringApplication.run(Week1Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				for (int i = 1; i<=10 ; i++){
					userRepository.save(new User(i, "User" +  i));
				}
			}
		};
	}
}
