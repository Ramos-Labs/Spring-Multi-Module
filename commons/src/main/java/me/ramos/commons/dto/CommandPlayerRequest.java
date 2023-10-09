package me.ramos.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.ramos.commons.domain.model.Player;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommandPlayerRequest {

    private String name;
    private Integer backNumber;
    private String nationality;
    private Long teamId;

    public Player toPlayer() {
        return Player.builder()
                .name(name)
                .backNumber(backNumber)
                .nationality(nationality)
                .build();
    }
}
