package me.ramos.commons.domain.repository;

import me.ramos.commons.domain.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

}