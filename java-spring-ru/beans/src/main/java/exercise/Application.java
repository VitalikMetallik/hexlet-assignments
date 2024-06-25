package exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

import exercise.daytime.Daytime;
import exercise.daytime.Day;
import exercise.daytime.Night;

// BEGIN
import org.springframework.context.annotation.Bean;
// END

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN

    @Bean
    public Daytime getDayTime() {
        var date = LocalDateTime.now();
        if (date.getHour() > 6 && date.getHour() <= 22) {
            return new Day();
        } else {
            return new Night();
        }
    }
    // END
}