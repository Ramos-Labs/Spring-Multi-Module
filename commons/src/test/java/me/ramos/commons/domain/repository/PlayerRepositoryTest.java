package me.ramos.commons.domain.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import me.ramos.commons.config.TestConfiguration;
import me.ramos.commons.domain.model.Player;
import me.ramos.commons.domain.model.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = TestConfiguration.class)
@ActiveProfiles("test")
@DataJpaTest
class PlayerRepositoryTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PlayerRepository repository;

    private Team team;

    @BeforeEach
    void setUp() {
        team = Team.builder()
                .name("Real Madrid")
                .league("La Liga")
                .build();

        entityManager.persist(team);
    }

    @Test
    void saveTest() throws Exception {
        //given
        Player player = Player.builder()
                .name("Vini Jr")
                .backNumber(7)
                .nationality("Brazil")
                .team(team)
                .build();

        //when
        Player savedPlayer = repository.save(player);

        //then
        assertThat(savedPlayer.getName()).isEqualTo(player.getName());
        assertThat(savedPlayer.getBackNumber()).isEqualTo(player.getBackNumber());
        assertThat(savedPlayer.getNationality()).isEqualTo(player.getNationality());
        assertThat(savedPlayer.getTeam()).isEqualTo(team);
    }

    @Test
    void findByIdTest() throws Exception {
        //given
        Player player = Player.builder()
                .name("Vini Jr")
                .backNumber(7)
                .nationality("Brazil")
                .team(team)
                .build();

        entityManager.persist(player);

        //when
        Optional<Player> optionalPlayer = repository.findById(player.getId());

        //then
        assertThat(optionalPlayer).isPresent();
        assertThat(optionalPlayer.get().getId()).isEqualTo(player.getId());
        assertThat(optionalPlayer.get().getName()).isEqualTo(player.getName());
        assertThat(optionalPlayer.get().getBackNumber()).isEqualTo(player.getBackNumber());
        assertThat(optionalPlayer.get().getNationality()).isEqualTo(player.getNationality());
        assertThat(optionalPlayer.get().getTeam()).isEqualTo(team);
    }
}