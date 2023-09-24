package me.ramos.commons.domain.repository;

import me.ramos.commons.domain.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
