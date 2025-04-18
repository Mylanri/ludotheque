package fr.eni.ludotheque.service;

import fr.eni.ludotheque.bo.Client;
import fr.eni.ludotheque.bo.Exemplaire;
import fr.eni.ludotheque.bo.Facture;
import fr.eni.ludotheque.bo.Location;
import fr.eni.ludotheque.repository.ClientRepository;
import fr.eni.ludotheque.repository.ExemplaireRepository;
import fr.eni.ludotheque.repository.FactureRepository;
import fr.eni.ludotheque.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class LocationService {

    @Autowired
    private LocationRepository LocationRepository;

    @Autowired
    private ExemplaireRepository exemplaireRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private FactureRepository factureRepository;

    public List<Location> getAll() {
        return LocationRepository.findAll();
    }

    public Location getById(Long locationId) {
        return LocationRepository.findById(locationId).orElse(null);
    }

    public Location create(Location location) {
        return LocationRepository.save(location);
    }

    public Location createWithCodebarre(@RequestBody Map<String, Object> payload) {

        String codebarre = payload.get("codebarre").toString();
        Long clientId = Long.valueOf(payload.get("clientId").toString());
        Long factureId = Long.valueOf(payload.get("factureId").toString());
        Double tarifJour = Double.valueOf(payload.get("tarifJour").toString());

        Exemplaire exemplaire = exemplaireRepository.findByCodebarre(codebarre);
        Client client = clientRepository.findById(clientId).orElse(null);
        Facture facture = factureRepository.findById(factureId).orElse(null);

        Location location = Location.builder()
                .exemplaire(exemplaire)
                .client(client)
                .facture(facture)
                .tarifJour(tarifJour)
                .dateDebut(LocalDate.now())
                .build();

        return LocationRepository.save(location);
    }

    public Location update(Location location) {
        location.setLocationId(location.getLocationId());
        return LocationRepository.save(location);
    }

    public void delete(Long locationId) {
        LocationRepository.deleteById(locationId);
    }

}
