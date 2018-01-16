package org.demo.springmongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ComponentScan({"org.demo.springmongo"})
@EnableMongoRepositories({"org.demo.springmongo"})
@SpringBootApplication
public class Application implements CommandLineRunner {
	@Autowired
	private ApplicationConfig appConfig;
	
	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
//        AbstractApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
		c.setIgnoreUnresolvablePlaceholders(true);

		return c;
	}

	@Override
	public void run(String... args) throws Exception {
//		repository.deleteAll();

		// create some users
		repository.save(new User("zz1@gmail.com", "zz1"));
		repository.save(new User("zz2@gmail.com", "zz2"));

		// fetch all users
		System.out.println("Users found with findAll():");
		System.out.println("-------------------------------");
		for (User user : repository.findAll()) {
			System.out.println(user);
		}
		System.out.println();

		// fetch an individual user
		System.out.println("User found with findByEmail('zz1@gmail.co'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByEmail("zz1@gmail.com"));
	}

}

