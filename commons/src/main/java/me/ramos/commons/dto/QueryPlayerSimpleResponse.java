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
public class QueryPlayerSimpleResponse {

    private Long playerId;
    private String name;
    private Integer backNumber;
    private String nationality;

    public static QueryPlayerSimpleResponse of(Player player) {
        return QueryPlayerSimpleResponse.builder()
                .playerId(player.getId())
                .name(player.getName())
                .backNumber(player.getBackNumber())
                .nationality(player.getNationality())
                .build();
    }
}
