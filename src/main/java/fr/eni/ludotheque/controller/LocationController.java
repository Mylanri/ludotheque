package fr.eni.ludotheque.controller;

import fr.eni.ludotheque.bo.Location;
import fr.eni.ludotheque.repository.LocationRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
@Tag(name = "Location API", description = "Gestion des locations de la ludothèque")
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping
    @Operation(summary = "Lister toutes les locations", description = "Récupère toutes les locations enregistrées dans la base.")
    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer une location par ID", description = "Retourne la location correspondant à l'identifiant fourni.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Location trouvée"),
            @ApiResponse(responseCode = "404", description = "Location non trouvée")
    })
    public Location getById(
            @Parameter(description = "ID de la location à récupérer", required = true)
            @PathVariable Long id) {
        return locationRepository.findById(id).orElse(null);
    }

    @PostMapping
    @Operation(summary = "Créer une nouvelle location", description = "Ajoute une nouvelle location dans la base de données.")
    @ApiResponse(responseCode = "201", description = "Location créée avec succès")
    public Location create(
            @Parameter(description = "Objet Location à créer", required = true)
            @RequestBody Location location) {
        return locationRepository.save(location);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour une location", description = "Met à jour une location existante avec de nouvelles données.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Location mise à jour"),
            @ApiResponse(responseCode = "404", description = "Location non trouvée")
    })
    public Location update(
            @Parameter(description = "ID de la location à mettre à jour", required = true)
            @PathVariable Long id,
            @Parameter(description = "Nouvelles données de la location", required = true)
            @RequestBody Location location) {
        location.setLocationId(id);
        return locationRepository.save(location);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer une location", description = "Supprime une location existante via son ID.")
    @ApiResponse(responseCode = "204", description = "Location supprimée avec succès")
    public void delete(
            @Parameter(description = "ID de la location à supprimer", required = true)
            @PathVariable Long id) {
        locationRepository.deleteById(id);
    }
}
