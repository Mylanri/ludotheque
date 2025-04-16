package fr.eni.ludotheque.bo;

import jakarta.persistence.*;
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
    @Column(name = "facture_id")
    private Long factureId;

    private LocalDate datePaiement;

    @OneToMany(mappedBy = "facture")
    private List<Location> locations;
}

