package fr.eni.ludotheque.controller;

import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.dto.AdresseDTO;
import fr.eni.ludotheque.repository.AdresseRepository;
import fr.eni.ludotheque.repository.ClientRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adresses")
@Tag(name = "Adresse API", description = "Gestion des adresses clients")
public class AdresseController {

    @Autowired
    private AdresseRepository adresseRepository;
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    @Operation(summary = "Lister toutes les adresses")
    public List<Adresse> getAll() {
        return adresseRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer une adresse par ID")
    public Adresse getById(@PathVariable Long id) {
        return adresseRepository.findById(id).orElse(null);
    }

    @PostMapping
    @Operation(summary = "Créer une nouvelle adresse")
    public Adresse create(@RequestBody AdresseDTO adresseDTO) {
        Adresse adresse = new Adresse();
        adresse.setRue(adresseDTO.getRue());
        adresse.setCodePostal(adresseDTO.getCodePostal());
        adresse.setVille(adresseDTO.getVille());

        return adresseRepository.save(adresse);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour une adresse")
    public Adresse update(@PathVariable Long id, @RequestBody Adresse adresse) {
        adresse.setAdresseId(id);
        return adresseRepository.save(adresse);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une adresse")
    public void delete(@PathVariable Long id) {
        adresseRepository.deleteById(id);
    }
}
