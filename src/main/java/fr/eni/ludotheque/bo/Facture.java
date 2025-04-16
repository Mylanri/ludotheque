package fr.eni.ludotheque.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
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

