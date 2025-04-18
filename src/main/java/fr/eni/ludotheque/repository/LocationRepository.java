package fr.eni.ludotheque.repository;

import fr.eni.ludotheque.bo.Exemplaire;
import fr.eni.ludotheque.bo.Location;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface LocationRepository extends JpaRepository<Location, Long> {
    @Modifying
    @Transactional
    @Query("INSERT INTO Location (exemplaire, dateDebut) SELECT e, CURRENT_DATE FROM Exemplaire e WHERE e.codebarre = :codebarre")
    Location addLocationWithCodeBarre(Location location, Exemplaire codebarre);
}
