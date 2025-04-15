package fr.eni.ludotheque.bo;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Location {
    @Id
    private Long noLocation;

    @Column(nullable = false)
    private LocalDate dateDebut;

    private LocalDate dateRetour;

    private Double tarifJour;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "exemplaire_id")
    private Exemplaire exemplaire;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "facture_id")
    private Facture facture;
}

