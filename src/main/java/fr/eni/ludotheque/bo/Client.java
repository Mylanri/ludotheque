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
public class Client {
    @Id
    @GeneratedValue
    private Long noClient;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String noTelephone;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "client")
    private Adresse adresse;

    @OneToMany(mappedBy = "client")
    private List<Location> locations;
}

