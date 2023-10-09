package me.ramos.commons.service;

import java.util.List;
import me.ramos.commons.dto.QueryPlayerResponse;

public interface QueryPlayerService {

    QueryPlayerResponse findByPlayerId(Long playerId);

    List<QueryPlayerResponse> findAll();
}
