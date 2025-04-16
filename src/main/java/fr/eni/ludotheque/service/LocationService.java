package fr.eni.ludotheque.service;

import fr.eni.ludotheque.bo.Location;
import fr.eni.ludotheque.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    private LocationRepository LocationRepository;

    public Location getById(Long locationId) {
        return LocationRepository.findById(locationId).orElse(null);
    }

}
