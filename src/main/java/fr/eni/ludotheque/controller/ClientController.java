package fr.eni.ludotheque.controller;

import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.repository.ClientRepository;
import fr.eni.ludotheque.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@Tag(name = "Client API", description = "Gestion des clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientService clientService;

    @GetMapping
    @Operation(summary = "Lister tous les clients")
    public List<Client> getAll() {
        return clientService.getAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Récupérer un client par ID")
    public Client getById(@PathVariable Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @GetMapping("/nom/{nom}")
    @Operation(summary = "Récupérer les clients par Nom")
    public List<Client>  getByNom(@PathVariable String nom) {
        return clientService.getByNom(nom);
    }

    @PostMapping
    @Operation(summary = "Créer un nouveau client")
    public Client create(@RequestBody Client client) {
        return clientService.create(client);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mettre à jour un client")
    public Client update(@PathVariable Long id, @RequestBody Client client) {
        client.setClientId(id);
        return clientRepository.save(client);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un client")
    public void delete(@PathVariable Long id) {
        clientService.deleteById(id);
    }
}
