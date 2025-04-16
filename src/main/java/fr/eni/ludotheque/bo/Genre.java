package fr.eni.ludotheque.bo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
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
