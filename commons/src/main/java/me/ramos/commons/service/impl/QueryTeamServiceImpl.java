package me.ramos.commons.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import me.ramos.commons.domain.model.Team;
import me.ramos.commons.domain.repository.TeamRepository;
import me.ramos.commons.dto.QueryTeamResponse;
import me.ramos.commons.service.QueryTeamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QueryTeamServiceImpl implements QueryTeamService {

    private final TeamRepository repository;

    @Override
    public QueryTeamResponse findByTeamId(Long teamId) {
        Team team = repository.findById(teamId).orElseThrow(RuntimeException::new);
        return QueryTeamResponse.of(team);
    }

    @Override
    public List<QueryTeamResponse> findAll() {
        return repository.findAllWithPlayer().stream()
                .map(QueryTeamResponse::of)
                .collect(Collectors.toList());
    }
}
