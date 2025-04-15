package fr.eni.ludotheque.controller;

import fr.eni.ludotheque.bo.Facture;
import fr.eni.ludotheque.repository.FactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factures")
public class FactureController {

    @Autowired
    private FactureRepository factureRepository;

    @GetMapping
    public List<Facture> getAll() {
        return factureRepository.findAll();
    }

    @GetMapping("/{id}")
    public Facture getById(@PathVariable Long id) {
        return factureRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Facture create(@RequestBody Facture facture) {
        return factureRepository.save(facture);
    }

    @PutMapping("/{id}")
    public Facture update(@PathVariable Long id, @RequestBody Facture facture) {
        facture.setNoFacture(id);
        return factureRepository.save(facture);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        factureRepository.deleteById(id);
    }
}
