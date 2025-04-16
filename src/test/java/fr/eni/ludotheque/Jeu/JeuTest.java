package fr.eni.ludotheque.Jeu;

import fr.eni.ludotheque.bo.Genre;
import fr.eni.ludotheque.bo.Jeu;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
@Slf4j
public class JeuTest {

    @Test
    void testAddJeu() {

        Genre genre = new Genre().builder()
                .noGenre(1L)
                .libelle("libelle")
                .build();

        Jeu jeu = new Jeu().builder()
                .noJeu(1L)
                .titre("titre")
                .reference("reference")
                .ageMin(13)
                .description("description")
                .duree(1)
                .tarifJour(1.0)
                .genres((List<Genre>) genre)
                .build();

        Assert.notNull(jeu, "Jeu null");

        log.info(jeu.toString());
    }

    @Test
    void testAddJeuWithSomeGenre() {

        Genre genre = new Genre().builder()
                .noGenre(1L)
                .libelle("libelle")
                .build();

        Genre genre2 = new Genre().builder()
                .noGenre(2L)
                .libelle("libelle2")
                .build();

        Jeu jeu = new Jeu().builder()
                .noJeu(1L)
                .titre("titre")
                .reference("reference")
                .ageMin(13)
                .description("description")
                .duree(1)
                .tarifJour(1.0)
                .genres(List.of(genre, genre2))
                .build();

        Assert.notNull(jeu, "Jeu null");

        log.info(jeu.toString());
    }

}
