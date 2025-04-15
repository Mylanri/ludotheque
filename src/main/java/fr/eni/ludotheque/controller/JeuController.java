package fr.eni.ludotheque.controller;

import fr.eni.ludotheque.bo.Jeu;
import fr.eni.ludotheque.repository.JeuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jeux")
public class JeuController {

    @Autowired
    private JeuRepository jeuRepository;

    @GetMapping
    public List<Jeu> getAll() {
        return jeuRepository.findAll();
    }

    @GetMapping("/{id}")
    public Jeu getById(@PathVariable Long id) {
        return jeuRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Jeu create(@RequestBody Jeu jeu) {
        return jeuRepository.save(jeu);
    }

    @PutMapping("/{id}")
    public Jeu update(@PathVariable Long id, @RequestBody Jeu jeu) {
        jeu.setNoJeu(id);
        return jeuRepository.save(jeu);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        jeuRepository.deleteById(id);
    }
}

