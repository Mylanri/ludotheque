package fr.eni.ludotheque.service;

import fr.eni.ludotheque.bo.Genre;
import fr.eni.ludotheque.bo.Jeu;
import fr.eni.ludotheque.repository.JeuRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@Slf4j
public class JeuServiceTest {

    @Mock
    private JeuRepository jeuRepository;

    @InjectMocks
    private JeuService jeuService;

    @Test
    void testCreateJeuWithGenre() {
        // given
        Genre genre = Genre.builder()
                .genreId(1L)
                .libelle("action")
                .build();

        Genre genre2 = Genre.builder()
                .genreId(2L)
                .libelle("comedie")
                .build();

        Jeu jeu = new Jeu().builder()
                .jeuId(1L)
                .titre("charlie")
                .reference("chaplin")
                .ageMin(13)
                .description("noir et blanc")
                .duree(1)
                .tarifJour(1.0)
                .genres(null)
                .build();
        // when
        when(jeuRepository.save(any(Jeu.class))).thenAnswer(invocation -> invocation.getArgument(0));
        Jeu savedJeu = jeuService.createJeuWithGenres(jeu, List.of(genre, genre2));
        // then
        log.info(savedJeu.toString());
    }

}
