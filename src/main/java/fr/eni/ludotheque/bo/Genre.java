package fr.eni.ludotheque.bo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Genre {
    @Id
    @GeneratedValue
    private Long noGenre;

    @Column(nullable = false)
    private String libelle;

    @OneToMany(mappedBy = "genre")
    private List<Jeu> jeux;
}
