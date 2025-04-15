package fr.eni.ludotheque.controller;

import fr.eni.ludotheque.bo.Genre;
import fr.eni.ludotheque.service.GenreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
@Tag(name = "Genre API", description = "Gestion des genres de jeux")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping
    @Operation(summary = "Lister tous les genres")
    public List<Genre> getAll() {
        return genreService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un genre par ID")
    public Genre getById(@PathVariable Long id) {
        return genreService.getById(id);
    }

    @PostMapping
    @Operation(summary = "Créer un nouveau genre")
    public Genre create(@RequestBody Genre genre) {
        return genreService.create(genre);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un genre")
    public Genre update(@PathVariable Long id, @RequestBody Genre genre) {
        return genreService.update(id, genre);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un genre")
    public void delete(@PathVariable Long id) {
        genreService.delete(id);
    }
}
