package me.ramos.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.ramos.commons.domain.model.Player;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryPlayerResponse {

    private Long id;
    private String name;
    private Integer backNumber;
    private String nationality;
    private String teamName;
    private String league;

    public static QueryPlayerResponse of(Player player) {
        return QueryPlayerResponse.builder()
                .id(player.getId())
                .name(player.getName())
                .backNumber(player.getBackNumber())
                .nationality(player.getNationality())
                .teamName(player.getTeam().getName())
                .league(player.getTeam().getLeague())
                .build();
    }
}
