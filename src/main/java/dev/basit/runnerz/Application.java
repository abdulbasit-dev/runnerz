package dev.basit.runnerz;

import dev.basit.runnerz.run.Location;
import dev.basit.runnerz.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            var runner = new Run(1, "Morning Run", LocalDateTime.now(), LocalDateTime.now().plusMinutes(30), 4, Location.INDOOR);
            System.out.println("Run: " + runner);
//            modify the title
            logger.info("Run: {}", runner);
        };
    }

}
