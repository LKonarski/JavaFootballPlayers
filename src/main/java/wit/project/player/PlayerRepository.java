package wit.project.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository
        extends JpaRepository<Player, Integer> {

    @Query("SELECT s FROM Player s WHERE s.initials = ?1")
    Optional<Player> findPlayerByInitials(String initials);
}
