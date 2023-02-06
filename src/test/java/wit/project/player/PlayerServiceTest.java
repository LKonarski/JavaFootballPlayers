package wit.project.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;
    private PlayerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new PlayerService(playerRepository);
    }


    @Test
    void canGetPlayers() {
        //when
        underTest.getPlayers();

        //then
        verify(playerRepository).findAll();
    }

    @Test
    void canAddNewPlayer() {
        //given
        Player player = new Player(
                "Robert",
                "Lewandowski",
                "RL9",
                LocalDate.of(1988, 8, 21),
                1.85,
                9,
                "Poland",
                "FC Barcelona",
                "Striker",
                "right",
                27,
                840,
                610,
                170,
                79,
                1
        );

        //when
        underTest.addNewPlayer(player);

        //then
        ArgumentCaptor<Player> playerArgumentCaptor =
                ArgumentCaptor.forClass(Player.class);

        verify(playerRepository)
                .save(playerArgumentCaptor.capture());

        Player captorPlayer = playerArgumentCaptor.getValue();

        assertThat(captorPlayer).isEqualTo(player);
    }

    @Test
    void willThrowWhenInitialsAreTaken() {
        //given
        Player player = new Player(
                "Robert",
                "Lewandowski",
                "RL9",
                LocalDate.of(1988, 8, 21),
                1.85,
                9,
                "Poland",
                "FC Barcelona",
                "Striker",
                "right",
                27,
                840,
                610,
                170,
                79,
                1
        );

        given(playerRepository.selectExistsInitials(player.getInitials()))
                .willReturn(true);

        //when
        //then
        assertThatThrownBy(() ->underTest.addNewPlayer(player))
                .hasMessageContaining("initials taken");
        verify(playerRepository, never()).save(any());
    }

    @Test
    @Disabled
    void deletePlayer() {
    }

    @Test
    @Disabled
    void updatePlayer() {
    }
}