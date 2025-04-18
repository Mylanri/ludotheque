package fr.eni.ludotheque.bo;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "exemplaire", uniqueConstraints = @UniqueConstraint(columnNames = {"codebarre"}))
public class Exemplaire {
    @Id
    @GeneratedValue
    @Column(name = "exemplaire_id")
    private Long exemplaireId;

    @Column(nullable = false, length = 13)
    private String codebarre;

    @Column(nullable = false)
    private Boolean louable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jeu_id" , referencedColumnName = "jeu_id")
    @JsonManagedReference
    private Jeu jeu;

    @OneToMany(mappedBy = "exemplaire")
    private List<Location> locations;
}

