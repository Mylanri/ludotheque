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
    @Column(name = "genre_id")
    private Long genreId;

    @Column(nullable = false)
    private String libelle;

    @ManyToMany(mappedBy = "genres")
    private List<Jeu> jeux;
}
