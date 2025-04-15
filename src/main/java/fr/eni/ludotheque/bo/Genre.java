package fr.eni.ludotheque.bo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Genre {
    @Id
    private Long noGenre;

    @Column(nullable = false)
    private String libelle;

    @OneToMany(mappedBy = "genre")
    private List<Jeu> jeux;
}
