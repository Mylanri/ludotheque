package fr.eni.ludotheque.repository;

import fr.eni.ludotheque.bo.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture, Long> {
}
