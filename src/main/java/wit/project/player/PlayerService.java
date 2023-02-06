package wit.project.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public void addNewPlayer(Player player) {
        boolean existInitials = playerRepository
                .selectExistsInitials(player.getInitials());
        if (existInitials) {
            throw new IllegalStateException("initials taken");
        }
        playerRepository.save(player);
    }

    public void deletePlayer(int playerId) {
        boolean exists = playerRepository.existsById(playerId);
        if (!exists) {
            throw new IllegalStateException("player with id " + playerId + "does not exist");
        }
        playerRepository.deleteById(playerId);
    }

    @Transactional
    public void updatePlayer(int playerId,
                             String name,
                             String initials) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new IllegalStateException(
                        "player with id " + playerId + "does not exist"));

        if (name != null &&
                name.length() > 0 &&
                !Objects.equals(player.getName(), name)) {
            player.setName(name);
        }

        if (initials != null &&
                initials.length() > 0 &&
                !Objects.equals(player.getInitials(), name)) {
            boolean existsInitials = playerRepository
                    .selectExistsInitials(initials);
            if (existsInitials) {
                throw new IllegalStateException("initials taken");
        }
            player.setInitials(initials);
        }
    }
}
