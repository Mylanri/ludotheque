package fr.eni.ludotheque.controller;

import fr.eni.ludotheque.bo.Facture;
import fr.eni.ludotheque.repository.FactureRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factures")
@Tag(name = "Facture API", description = "Gestion des factures clients")
public class FactureController {

    @Autowired
    private FactureRepository factureRepository;

    @GetMapping
    @Operation(summary = "Lister toutes les factures")
    public List<Facture> getAll() {
        return factureRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer une facture par ID")
    public Facture getById(@PathVariable Long id) {
        return factureRepository.findById(id).orElse(null);
    }

    @PostMapping
    @Operation(summary = "Créer une nouvelle facture")
    public Facture create(@RequestBody Facture facture) {
        return factureRepository.save(facture);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour une facture")
    public Facture update(@PathVariable Long id, @RequestBody Facture facture) {
        facture.setNoFacture(id);
        return factureRepository.save(facture);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une facture")
    public void delete(@PathVariable Long id) {
        factureRepository.deleteById(id);
    }
}
