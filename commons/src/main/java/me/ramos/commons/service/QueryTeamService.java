package me.ramos.commons.service;

import java.util.List;
import me.ramos.commons.dto.QueryTeamResponse;

public interface QueryTeamService {

    QueryTeamResponse findByTeamId(Long teamId);

    List<QueryTeamResponse> findAll();
}
