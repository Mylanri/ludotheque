package fr.eni.ludotheque.service;

import fr.eni.ludotheque.bo.Genre;
import fr.eni.ludotheque.bo.Jeu;
import fr.eni.ludotheque.repository.JeuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JeuService {

    @Autowired
    private JeuRepository jeuRepository;

    public List<Jeu> getAll() {
        return jeuRepository.findAll();
    }

    public Jeu getById(Long id) {
        return jeuRepository.findById(id).orElse(null);
    }

    public Jeu create(Jeu jeu) {
        return jeuRepository.save(jeu);
    }

    public Jeu createJeuWithGenres(Jeu jeu, List<Genre> genres) {
        jeu.setGenres(genres);
        return jeuRepository.save(jeu);
    }

    public Jeu update(Long id, Jeu jeu) {
        jeu.setJeuId(id);
        return jeuRepository.save(jeu);
    }

    public void delete(Long id) {
        jeuRepository.deleteById(id);
    }
}
