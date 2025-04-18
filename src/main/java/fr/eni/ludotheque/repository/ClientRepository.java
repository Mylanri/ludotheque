package fr.eni.ludotheque.repository;

import fr.eni.ludotheque.bo.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("SELECT c FROM Client c WHERE c.nom LIKE CONCAT('%', :nom, '%')")
    List<Client> findByNom(String nom);
}
