package me.ramos.commons.dto;

import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.ramos.commons.domain.model.Team;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryTeamResponse {

    private Long teamId;
    private String teamName;
    private String league;
    private List<QueryPlayerSimpleResponse> players;

    public static QueryTeamResponse of(Team team) {
        List<QueryPlayerSimpleResponse> players = team.getPlayers().stream()
                .map(QueryPlayerSimpleResponse::of)
                .collect(Collectors.toList());

        return QueryTeamResponse.builder()
                .teamId(team.getId())
                .teamName(team.getName())
                .league(team.getLeague())
                .players(players)
                .build();
    }
}
