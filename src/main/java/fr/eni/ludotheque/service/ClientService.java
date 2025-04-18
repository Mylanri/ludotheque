package fr.eni.ludotheque.service;

import fr.eni.ludotheque.bo.Adresse;
import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService  {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    public Client getById(Long id){
        return clientRepository.getReferenceById(id);
    }

    public Client create(Client client) {
        if (client.getAdresse() != null) {
            client.setAdresse(client.getAdresse());
        }
        return clientRepository.save(client);
    }

    public List<Client> getByNom(String nom) {
        return clientRepository.findByNom(nom);
    }

    public void deleteById(Long id){
        clientRepository.deleteById(id);
    }
}
