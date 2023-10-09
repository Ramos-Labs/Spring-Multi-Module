package me.ramos.commons.domain.repository;

import java.util.List;
import me.ramos.commons.domain.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("select distinct p from Player p join fetch p.team")
    List<Player> findAllWithTeam();
}
