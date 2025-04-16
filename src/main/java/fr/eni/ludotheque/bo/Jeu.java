package fr.eni.ludotheque.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
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
public class Jeu {
    @Id
    @GeneratedValue
    @Column(name = "jeu_id")
    private Long jeuId;

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

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "jeu_genre",
            joinColumns = @JoinColumn(name = "jeu_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;
}
