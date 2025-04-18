package fr.eni.ludotheque.repository;

import fr.eni.ludotheque.bo.Exemplaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExemplaireRepository extends JpaRepository<Exemplaire, Long> {
    Exemplaire findByCodebarre(String codebarre);
}
