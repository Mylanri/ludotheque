package fr.eni.ludotheque.controller;

import fr.eni.ludotheque.bo.Jeu;
import fr.eni.ludotheque.service.JeuService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jeux")
@Tag(name = "Jeu API", description = "Gestion des jeux de la ludothèque")
public class JeuController {

    @Autowired
    private JeuService jeuService;

    @GetMapping
    @Operation(summary = "Lister tous les jeux", description = "Récupère tous les jeux disponibles.")
    public List<Jeu> getAll() {
        return jeuService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un jeu par ID")
    public Jeu getById(@Parameter(description = "ID du jeu") @PathVariable Long id) {
        return jeuService.getById(id);
    }

    @PostMapping
    @Operation(summary = "Créer un nouveau jeu")
    public Jeu create(@Parameter(description = "Objet Jeu à créer") @RequestBody Jeu jeu) {
        return jeuService.create(jeu);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un jeu existant")
    public Jeu update(@PathVariable Long id, @RequestBody Jeu jeu) {
        return jeuService.update(id, jeu);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un jeu")
    public void delete(@PathVariable Long id) {
        jeuService.delete(id);
    }
}