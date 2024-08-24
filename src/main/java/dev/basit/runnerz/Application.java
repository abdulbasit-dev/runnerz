package dev.basit.runnerz;

import dev.basit.runnerz.user.User;
import dev.basit.runnerz.user.UserRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

    @Bean
    CommandLineRunner runner(UserRestClient client) {
        return args -> {
            List<User> users = client.findAll();
            logger.info("Users");
            System.out.println(users);
        };
    }
}
