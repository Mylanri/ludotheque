package fr.eni.ludotheque.service;

import fr.eni.ludotheque.bo.Exemplaire;
import fr.eni.ludotheque.bo.Jeu;
import fr.eni.ludotheque.bo.Location;
import fr.eni.ludotheque.repository.ExemplaireRepository;
import fr.eni.ludotheque.repository.LocationRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@Slf4j
public class LocationServiceTest {

    @Mock
    private ExemplaireRepository exemplaireRepository;

    @Mock
    private LocationRepository locationRepository;

    private final Jeu jeu = new Jeu().builder()
            .jeuId(1L)
            .titre("charlie")
            .reference("chaplin")
            .ageMin(13)
            .description("noir et blanc")
            .duree(1)
            .tarifJour(1.0)
            .genres(null)
            .build();

    @Test
    void testCreateLocation() {
        // given
        Location location = new Location().builder()
                .locationId(1L)
                .dateDebut(LocalDate.now())
                .dateRetour(null)
                .tarifJour(1.0)
                .client(null)
                .exemplaire(null)
                .facture(null)
                .build();
        //when
        when(locationRepository.save(any(Location.class))).thenReturn(location);
        Location savedLocation = locationRepository.save(location);
        //then
        assertThat(savedLocation).isNotNull();
        log.info(savedLocation.toString());
    }

    @Test
    void testCreateLocationWithExemplaire() {
        // given
        Location location = new Location().builder()
                .locationId(1L)
                .dateDebut(LocalDate.now())
                .dateRetour(null)
                .tarifJour(1.0)
                .client(null)
                .exemplaire(null)
                .facture(null)
                .build();

        Exemplaire exemplaire = new Exemplaire().builder()
                .exemplaireId(1L)
                .codebarre("codebarre")
                .louable(true)
                .jeu(jeu)
                .locations(List.of(location))
                .build();
        //when
        when(locationRepository.save(any(Location.class))).thenReturn(location);
        when(exemplaireRepository.save(any(Exemplaire.class))).thenReturn(exemplaire);
        Exemplaire savedExemplaire = exemplaireRepository.save(exemplaire);
        //then
        assertThat(savedExemplaire).isNotNull();
        log.info(savedExemplaire.toString());
    }
}
