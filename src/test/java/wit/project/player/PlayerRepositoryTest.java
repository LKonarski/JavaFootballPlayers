package wit.project.player;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class PlayerRepositoryTest {

    @Autowired
    private PlayerRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckIfPlayerInitialsExists() {
        // given
        String initials = "LM10";
        Player player = new Player(
                "Lionel",
                "Messi",
                initials,
                LocalDate.of(1987, 06, 24),
                1.69,
                30,
                "Argentina",
                "PSG FC",
                "Defender",
                "Left",
                37,
                1030,
                800,
                388,
                95,
                5
        );
        underTest.save(player);

        // when
        boolean expected = underTest.selectExistsInitials(initials);

        // then
        assertThat(expected).isTrue();
    }

    @Test
    void itShouldCheckIfPlayerInitialsDoesNotExist() {
        // given
        String initials = "LM9";

        // when
        boolean expected = underTest.selectExistsInitials(initials);

        // then
        assertThat(expected).isFalse();
    }
}