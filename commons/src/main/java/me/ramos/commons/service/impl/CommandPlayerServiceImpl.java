package me.ramos.commons.service.impl;

import lombok.RequiredArgsConstructor;
import me.ramos.commons.domain.model.Player;
import me.ramos.commons.domain.model.Team;
import me.ramos.commons.domain.repository.PlayerRepository;
import me.ramos.commons.domain.repository.TeamRepository;
import me.ramos.commons.dto.CommandPlayerRequest;
import me.ramos.commons.service.CommandPlayerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommandPlayerServiceImpl implements CommandPlayerService {

    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    @Override
    public Long insertPlayer(CommandPlayerRequest request) {
        Team team = teamRepository.findById(request.getTeamId()).orElseThrow(RuntimeException::new);

        Player player = request.toPlayer();
        player.setTeam(team);

        return playerRepository.save(player).getId();
    }
}
