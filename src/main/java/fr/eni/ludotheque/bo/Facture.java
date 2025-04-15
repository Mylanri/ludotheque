package fr.eni.ludotheque.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Facture {
    @Id
    private Long noFacture;

    private LocalDate datePaiement;
}

