package fr.eni.ludotheque.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
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
    @Min(13)
    private String reference;

    @Column(nullable = false)
    private Integer ageMin;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer duree;

    @Column(nullable = false)
    private Double tarifJour;

    @OneToMany(mappedBy = "jeu")
    private List<Exemplaire> exemplaires;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
}
