package me.ramos.api.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import me.ramos.commons.domain.model.Player;
import me.ramos.commons.service.QueryPlayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class QueryPlayerController {

    private final QueryPlayerService queryPlayerService;

    @GetMapping
    public List<Player> findAll() {
        return queryPlayerService.findAll();
    }

    @GetMapping("/{playerId}")
    public Player findByPlayerId(@PathVariable Long playerId) {
        return queryPlayerService.findByPlayerId(playerId);
    }

}
