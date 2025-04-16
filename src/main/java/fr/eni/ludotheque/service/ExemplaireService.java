package fr.eni.ludotheque.service;

import fr.eni.ludotheque.bo.Exemplaire;
import fr.eni.ludotheque.repository.ExemplaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExemplaireService {

    @Autowired
    private ExemplaireRepository ExemplaireRepository;

    public Exemplaire getById(Long id) {
        return ExemplaireRepository.findById(id).orElse(null);
    }

}
