package fr.eni.ludotheque.controller;

import fr.eni.ludotheque.bo.Genre;
import fr.eni.ludotheque.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    @Autowired
    private GenreRepository genreRepository;

    @GetMapping
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    @GetMapping("/{id}")
    public Genre getById(@PathVariable Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Genre create(@RequestBody Genre genre) {
        return genreRepository.save(genre);
    }

    @PutMapping("/{id}")
    public Genre update(@PathVariable Long id, @RequestBody Genre genre) {
        genre.setNoGenre(id);
        return genreRepository.save(genre);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        genreRepository.deleteById(id);
    }
}
