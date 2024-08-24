package dev.basit.runnerz;

import dev.basit.runnerz.user.User;
import dev.basit.runnerz.user.UserHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.List;

@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }


    @Bean
    UserHttpClient userHttpClient() {
        RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com");
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();
        return factory.createClient(UserHttpClient.class);

    }

    @Bean
    CommandLineRunner runner(UserHttpClient client) {
        return args -> {
            List<User> users = client.findAll();
            logger.info("Users");
            System.out.println(users);

            logger.info("User with id 1");
            User user = client.findById(1);
            System.out.println(user);
        };
    }

//    @Bean
//    CommandLineRunner runner(UserRestClient client) {
//        return args -> {
//            List<User> users = client.findAll();
//            logger.info("Users");
//            System.out.println(users);
//        };
//    }
}
