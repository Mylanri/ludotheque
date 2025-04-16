package fr.eni.ludotheque.controller;

import fr.eni.ludotheque.bo.Exemplaire;
import fr.eni.ludotheque.repository.ExemplaireRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exemplaires")
@Tag(name = "Exemplaire API", description = "Gestion des exemplaires de jeux")
public class ExemplaireController {

    @Autowired
    private ExemplaireRepository exemplaireRepository;

    @GetMapping
    @Operation(summary = "Lister tous les exemplaires")
    public List<Exemplaire> getAll() {
        return exemplaireRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un exemplaire par ID")
    public Exemplaire getById(@PathVariable Long id) {
        return exemplaireRepository.findById(id).orElse(null);
    }

    @PostMapping
    @Operation(summary = "Créer un nouvel exemplaire")
    public Exemplaire create(@RequestBody Exemplaire exemplaire) {
        return exemplaireRepository.save(exemplaire);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un exemplaire")
    public Exemplaire update(@PathVariable Long id, @RequestBody Exemplaire exemplaire) {
        exemplaire.setExemplaireId(id);
        return exemplaireRepository.save(exemplaire);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un exemplaire")
    public void delete(@PathVariable Long id) {
        exemplaireRepository.deleteById(id);
    }
}
