package me.ramos.api.controller;

import lombok.RequiredArgsConstructor;
import me.ramos.commons.dto.CommandTeamRequest;
import me.ramos.commons.service.CommandTeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class CommandTeamController {

    private final CommandTeamService commandTeamService;

    @PostMapping
    public ResponseEntity<String> insertTeam(@RequestBody CommandTeamRequest request) {
        commandTeamService.insertTeam(request);
        return ResponseEntity.ok("ok");
    }
}
