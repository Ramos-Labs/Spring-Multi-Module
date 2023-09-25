package me.ramos.commons.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import me.ramos.commons.domain.model.Player;
import me.ramos.commons.domain.repository.PlayerRepository;
import me.ramos.commons.dto.QueryPlayerResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QueryPlayerService {

    private final PlayerRepository playerRepository;

    public QueryPlayerResponse findByPlayerId(Long playerId) {
        Player player = playerRepository.findById(playerId).orElseThrow(RuntimeException::new);
        return QueryPlayerResponse.of(player);
    }

    public List<QueryPlayerResponse> findAll() {
        return playerRepository.findAllWithTeam().stream()
                .map(QueryPlayerResponse::of)
                .collect(Collectors.toList());
    }
}
