package wit.project.player;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class PlayerConfig {

    @Bean
    CommandLineRunner commandLineRunner(PlayerRepository repository) {
        return args -> {
            Player Cristiano = new Player(
                    1,
                    "Cristiano Ronaldo",
                    "Dos Santos Aveiro",
                    "CR7",
                    LocalDate.of(1985, 02, 05),
                    1.87,
                    7,
                    "Portugal",
                    "Al-Nassr FC",
                    "Striker",
                    "Right",
                    34,
                    819,
                    277,
                    150,
                    7
            );

            Player Lionel = new Player(
                    "Lionel",
                    "Messi",
                    "LM10",
                    LocalDate.of(1987, 06, 24),
                    1.69,
                    30,
                    "Argentina",
                    "PSG FC",
                    "Winger",
                    "Left",
                    37,
                    800,
                    388,
                    95,
                    4
            );

            repository.saveAll(
                    List.of(Cristiano, Lionel)
            );
        };
    }
}
