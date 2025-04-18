package fr.eni.ludotheque.bo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "adresse")
public class Adresse {
    @Id
    @GeneratedValue
    @Column(name = "adresse_id")
    private Long adresseId;

    @Column(nullable = false)
    private String rue;

    @Column(nullable = false)
    private String codePostal;

    @Column(nullable = false)
    private String ville;

}

