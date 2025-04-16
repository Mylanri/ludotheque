package fr.eni.ludotheque.Exemplaire;

import fr.eni.ludotheque.bo.Exemplaire;
import fr.eni.ludotheque.bo.Genre;
import fr.eni.ludotheque.bo.Jeu;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
@Slf4j
public class ExemplaireTest {

    @Test
    void testAddExemplaire() {

        Genre genre = new Genre().builder()
                .genreId(1L)
                .libelle("libelle")
                .build();

        Jeu jeu = new Jeu().builder()
                .jeuId(1L)
                .titre("titre")
                .reference("reference")
                .ageMin(13)
                .description("description")
                .duree(1)
                .tarifJour(1.0)
                .genres((List<Genre>) genre)
                .build();

        Exemplaire exemplaire = new Exemplaire().builder()
                .exemplaireId(1L)
                .codebarre("codebarre")
                .louable(true)
                .jeu(jeu)
                .build();

        Assert.notNull(exemplaire, "Exemplaire not null");

        log.info(exemplaire.toString());
    }

}
