package me.ramos.commons.service.impl;

import lombok.RequiredArgsConstructor;
import me.ramos.commons.domain.repository.TeamRepository;
import me.ramos.commons.dto.CommandTeamRequest;
import me.ramos.commons.service.CommandTeamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommandTeamServiceImpl implements CommandTeamService {

    private final TeamRepository teamRepository;

    @Override
    public Long insertTeam(CommandTeamRequest request) {
        return teamRepository.save(request.toTeam()).getId();
    }
}
