package me.ramos.api.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import me.ramos.commons.dto.QueryTeamResponse;
import me.ramos.commons.service.QueryTeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class QueryTeamController {

    private final QueryTeamService queryTeamService;

    @GetMapping("/{teamId}")
    public QueryTeamResponse findByTeamId(@PathVariable Long teamId) {
        return queryTeamService.findByTeamId(teamId);
    }

    @GetMapping
    public List<QueryTeamResponse> findAll() {
        return queryTeamService.findAll();
    }
}
