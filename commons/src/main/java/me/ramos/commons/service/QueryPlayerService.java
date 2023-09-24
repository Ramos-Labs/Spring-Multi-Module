package me.ramos.commons.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import me.ramos.commons.domain.model.Player;
import me.ramos.commons.domain.repository.PlayerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class QueryPlayerService {

    private final PlayerRepository playerRepository;

    public Player findByPlayerId(Long playerId) {
        return playerRepository.findById(playerId).orElseThrow(RuntimeException::new);
    }

    public List<Player> findAll() {
        return playerRepository.findAll();
    }
}
