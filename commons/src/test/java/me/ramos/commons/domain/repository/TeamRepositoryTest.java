package me.ramos.commons.domain.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    @PersistenceContext
    private EntityManager entityManager;

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

    @Test
    void findByIdTest() throws Exception {
        //given
        Team team = Team.builder()
                .name("Real Madrid")
                .league("La Liga")
                .build();

        entityManager.persist(team);

        //when
        Optional<Team> optionalTeam = repository.findById(team.getId());

        //then
        assertThat(optionalTeam).isPresent();
        assertThat(optionalTeam.get().getId()).isEqualTo(team.getId());
        assertThat(optionalTeam.get().getName()).isEqualTo(team.getName());
        assertThat(optionalTeam.get().getLeague()).isEqualTo(team.getLeague());
        assertThat(optionalTeam.get().getPlayers()).isEmpty();
    }
}