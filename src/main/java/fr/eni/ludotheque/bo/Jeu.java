package fr.eni.ludotheque.bo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
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

    @Column(nullable = false, length = 100)
    private String titre;

    @Column(nullable = false, length = 50)
    @Min(13)
    private String reference;

    @Column(nullable = false)
    private Integer ageMin;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(nullable = false)
    private Integer duree;

    @Column(nullable = false)
    private Double tarifJour;

    @OneToMany(mappedBy = "jeu", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Exemplaire> exemplaires;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "jeu_genre",
            joinColumns = @JoinColumn(name = "jeu_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;
}