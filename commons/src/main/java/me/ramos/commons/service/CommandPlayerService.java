package me.ramos.commons.service;

import me.ramos.commons.dto.CommandPlayerRequest;

public interface CommandPlayerService {

    Long insertPlayer(CommandPlayerRequest request);
}
