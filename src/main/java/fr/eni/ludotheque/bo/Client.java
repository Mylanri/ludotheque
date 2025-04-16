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
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue
    @Column(name = "client_id")
    private Long clientId;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String noTelephone;

    @OneToOne
    @JoinColumn(name = "adresse_id", referencedColumnName = "adresse_id")
    private Adresse adresse;

    @OneToMany(mappedBy = "client")
    private List<Location> locations;
}

