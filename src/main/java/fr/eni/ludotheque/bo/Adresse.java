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
public class Adresse {
    @Id
    private Long noAdresse;

    @Column(nullable = false)
    private String rue;

    @Column(nullable = false)
    private String codePostal;

    @Column(nullable = false)
    private String ville;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;
}

