package wit.project.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository
        extends JpaRepository<Player, Integer> {

    @Query("SELECT CASE WHEN COUNT(s) > 0 THEN " +
            "TRUE ELSE FALSE END " +
            "FROM Player s " +
            "WHERE s.initials = ?1")
    boolean selectExistsInitials(String initials);

}