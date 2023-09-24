package me.ramos.commons.domain.repository;

import static org.assertj.core.api.Assertions.assertThat;

import me.ramos.commons.config.TestConfiguration;
import me.ramos.commons.domain.model.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = TestConfiguration.class)
@ActiveProfiles("test")
@DataJpaTest
class TeamRepositoryTest {

    @Autowired
    private TeamRepository repository;

    @Test
    void saveTest() throws Exception {
        //given
        Team team = Team.builder()
                .name("Real Madrid")
                .league("La Liga")
                .build();

        //when
        Team savedTeam = repository.save(team);

        //then
        assertThat(savedTeam.getName()).isEqualTo(team.getName());
        assertThat(savedTeam.getLeague()).isEqualTo(team.getLeague());
        assertThat(savedTeam.getPlayers()).isEmpty();
    }
}