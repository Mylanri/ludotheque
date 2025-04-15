package fr.eni.ludotheque.dto;

import lombok.Data;

@Data
public class AdresseDTO {
    private String rue;
    private String codePostal;
    private String ville;
    private Long clientId; // Juste l'ID du client, pas tout l'objet
}

