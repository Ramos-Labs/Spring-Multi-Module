package me.ramos.commons.domain.repository;

import java.util.List;
import me.ramos.commons.domain.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query("select distinct t from Team t left join fetch t.players")
    List<Team> findAllWithPlayer();
}
