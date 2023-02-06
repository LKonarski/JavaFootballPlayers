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
                    1148,
                    820,
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
                    1030,
                    801,
                    388,
                    95,
                    4
            );

            Player Robert = new Player(
                    "Robert",
                    "Lewandowski",
                    "RL9",
                    LocalDate.of(1988, 8, 21),
                    1.85,
                    9,
                    "Poland",
                    "FC Barcelona",
                    "Striker",
                    "Right",
                    27,
                    840,
                    610,
                    170,
                    79,
                    2
            );

            Player Kylian = new Player(
                    "Kylian",
                    "Mbappe Lottin",
                    "KM7",
                    LocalDate.of(1998, 12, 20),
                    1.78,
                    7,
                    "France",
                    "PSG FC",
                    "Striker",
                    "Right",
                    14,
                    374,
                    264,
                    135,
                    43,
                    3
            );


            repository.saveAll(
                    List.of(Cristiano, Lionel, Robert, Kylian)
            );
        };
    }
}
