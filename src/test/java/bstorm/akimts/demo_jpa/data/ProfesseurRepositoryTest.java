package bstorm.akimts.demo_jpa.data;

import bstorm.akimts.demo_jpa.models.entities.Professeur;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
class ProfesseurRepositoryTest {

    private final SimpleCrudRepository<Professeur, Long> repo;

    ProfesseurRepositoryTest(ProfesseurRepository repo) {
        this.repo = repo;
    }

    @Test
    void getOne_optEmpty_if_idInvalid() {
        Optional<Professeur> professeur = repo.getOne(99999L);
        assertTrue(professeur.isEmpty());
    }
    @Test
    void getOne_correctProf_if_idValid() {
        long id = 1;
        Optional<Professeur> professeur = repo.getOne(id);
        assertEquals(professeur.orElseThrow().getId(), id);
    }

    @Test
    void getAll() {
        assertEquals(repo.getAll().size(), 6);
    }

    @Test
    void insert() {

        Professeur toInsert = new Professeur(
                10,
                "test",
                "test_",
                "email",
                1010,
                400,
                LocalDateTime.now(),
                2000
        );

        assertDoesNotThrow(() -> repo.insert(toInsert));

        Professeur inserted = repo.getOne(10L).get();

        assertEquals( toInsert, inserted );
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }
}