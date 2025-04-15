package fr.eni.ludotheque.controller;

import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.repository.AdresseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adresses")
public class AdresseController {

    @Autowired
    private AdresseRepository adresseRepository;

    @GetMapping
    public List<Adresse> getAll() {
        return adresseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Adresse getById(@PathVariable Long id) {
        return adresseRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Adresse create(@RequestBody Adresse adresse) {
        return adresseRepository.save(adresse);
    }

    @PutMapping("/{id}")
    public Adresse update(@PathVariable Long id, @RequestBody Adresse adresse) {
        adresse.setNoAdresse(id);
        return adresseRepository.save(adresse);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        adresseRepository.deleteById(id);
    }
}
