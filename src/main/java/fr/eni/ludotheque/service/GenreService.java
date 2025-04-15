package fr.eni.ludotheque.service;

import fr.eni.ludotheque.bo.Genre;
import fr.eni.ludotheque.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> getAll() {
        return genreRepository.findAll();
    }

    public Genre getById(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    public Genre create(Genre genre) {
        return genreRepository.save(genre);
    }

    public Genre update(Long id, Genre genre) {
        genre.setNoGenre(id);
        return genreRepository.save(genre);
    }

    public void delete(Long id) {
        genreRepository.deleteById(id);
    }
}

