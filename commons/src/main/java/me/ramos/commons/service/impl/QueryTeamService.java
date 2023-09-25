package me.ramos.commons.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import me.ramos.commons.domain.model.Team;
import me.ramos.commons.domain.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QueryTeamService {

    private final TeamRepository repository;

    public Team findByTeamId(Long teamId) {
        return repository.findById(teamId).orElseThrow(RuntimeException::new);
    }

    public List<Team> findAll() {
        return repository.findAll();
    }
}
