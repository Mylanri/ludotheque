package fr.eni.ludotheque.bo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Client {
    @Id
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

