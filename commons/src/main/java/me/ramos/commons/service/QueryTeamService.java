package me.ramos.commons.service;

import java.util.List;
import me.ramos.commons.domain.model.Team;

public interface QueryTeamService {

    Team findByTeamId(Long teamId);

    List<Team> findAll();
}
