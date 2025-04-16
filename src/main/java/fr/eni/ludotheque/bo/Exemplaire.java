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
public class Exemplaire {
    @Id
    @GeneratedValue
    @Column(name = "exemplaire_id")
    private Long exemplaireId;

    @Column(nullable = false)
    private String codebarre;

    @Column(nullable = false)
    private Boolean louable;

    @ManyToOne
    @JoinColumn(name = "jeu_id" , referencedColumnName = "jeu_id")
    private Jeu jeu;

    @OneToMany(mappedBy = "exemplaire")
    private List<Location> locations;
}

