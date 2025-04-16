package fr.eni.ludotheque.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Facture {
    @Id
    @GeneratedValue
    private Long noFacture;

    private LocalDate datePaiement;

    @OneToMany(mappedBy = "facture")
    private List<Facture> factures;
}

