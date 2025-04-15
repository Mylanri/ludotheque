package fr.eni.ludotheque.controller;

import fr.eni.ludotheque.bo.Exemplaire;
import fr.eni.ludotheque.repository.ExemplaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exemplaires")
public class ExemplaireController {

    @Autowired
    private ExemplaireRepository exemplaireRepository;

    @GetMapping
    public List<Exemplaire> getAll() {
        return exemplaireRepository.findAll();
    }

    @GetMapping("/{id}")
    public Exemplaire getById(@PathVariable Long id) {
        return exemplaireRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Exemplaire create(@RequestBody Exemplaire exemplaire) {
        return exemplaireRepository.save(exemplaire);
    }

    @PutMapping("/{id}")
    public Exemplaire update(@PathVariable Long id, @RequestBody Exemplaire exemplaire) {
        exemplaire.setNoExemplaire(id);
        return exemplaireRepository.save(exemplaire);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        exemplaireRepository.deleteById(id);
    }
}
