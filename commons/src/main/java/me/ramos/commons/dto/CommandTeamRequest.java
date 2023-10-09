package me.ramos.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.ramos.commons.domain.model.Team;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommandTeamRequest {

    private String name;
    private String league;

    public Team toTeam() {
        return Team.builder()
                .name(name)
                .league(league)
                .build();
    }
}
