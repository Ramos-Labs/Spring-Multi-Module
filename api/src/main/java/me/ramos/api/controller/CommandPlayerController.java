package me.ramos.api.controller;

import lombok.RequiredArgsConstructor;
import me.ramos.commons.dto.CommandPlayerRequest;
import me.ramos.commons.service.CommandPlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players")
@RequiredArgsConstructor
public class CommandPlayerController {

    private final CommandPlayerService commandPlayerService;

    @PostMapping
    public ResponseEntity<Long> insertPlayer(@RequestBody CommandPlayerRequest request) {
        return ResponseEntity.ok(commandPlayerService.insertPlayer(request));
    }
}
