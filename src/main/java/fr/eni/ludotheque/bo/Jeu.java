package fr.eni.ludotheque.bo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Jeu {
    @Id
    @GeneratedValue
    private Long noJeu;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private String reference;

    private Integer ageMin;
    private String description;
    private Integer duree;

    @Column(nullable = false)
    private Double tarifJour;

    @OneToMany(mappedBy = "jeu")
    private List<Exemplaire> exemplaires;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
