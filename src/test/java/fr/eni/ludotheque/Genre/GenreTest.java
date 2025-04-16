package fr.eni.ludotheque.Genre;

import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.bo.Genre;
import fr.eni.ludotheque.bo.Jeu;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
@Slf4j
public class GenreTest {

    @Test
    void testAddGenre() {
        Genre genre = new Genre().builder()
                .noGenre(1L)
                .libelle("libelle")
                .jeux(null)
                .build();

        Assert.notNull(genre, "Genre not null");

        log.info(genre.toString());
    }

    @Test
    void testAddGenreWithGames() {

        Jeu jeu = Jeu.builder()
                .noJeu(1L)
                .titre("titre")
                .reference("reference")
                .ageMin(13)
                .description("description")
                .duree(1)
                .tarifJour(1.0)
                .build();

        Jeu jeu2 = Jeu.builder()
                .noJeu(2L)
                .titre("titre2")
                .reference("reference2")
                .ageMin(14)
                .description("description2")
                .duree(2)
                .tarifJour(2.0)
                .build();

        Genre genre = Genre.builder()
                .libelle("libelle")
                .jeux(List.of(jeu, jeu2))
                .build();

        Assert.notNull(genre, "Genre not null");

        log.info(genre.toString());
    }

}
