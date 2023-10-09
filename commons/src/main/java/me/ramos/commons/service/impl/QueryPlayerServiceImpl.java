package me.ramos.commons.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import me.ramos.commons.domain.model.Player;
import me.ramos.commons.domain.repository.PlayerRepository;
import me.ramos.commons.dto.QueryPlayerResponse;
import me.ramos.commons.service.QueryPlayerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QueryPlayerServiceImpl implements QueryPlayerService {

    private final PlayerRepository playerRepository;

    @Override
    public QueryPlayerResponse findByPlayerId(Long playerId) {
        Player player = playerRepository.findById(playerId).orElseThrow(RuntimeException::new);
        return QueryPlayerResponse.of(player);
    }

    @Override
    public List<QueryPlayerResponse> findAll() {
        return playerRepository.findAllWithTeam().stream()
                .map(QueryPlayerResponse::of)
                .collect(Collectors.toList());
    }
}
