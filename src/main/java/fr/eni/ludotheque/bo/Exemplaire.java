package fr.eni.ludotheque.bo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Exemplaire {
    @Id
    @GeneratedValue
    private Long noExemplaire;

    @Column(nullable = false)
    private String codebarre;

    @Column(nullable = false)
    private Boolean louable;

    @ManyToOne
    @JoinColumn(name = "jeu_id")
    private Jeu jeu;

    @OneToMany(mappedBy = "exemplaire")
    private List<Location> locations;
}

