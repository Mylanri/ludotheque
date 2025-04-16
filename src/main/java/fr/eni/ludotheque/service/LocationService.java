package fr.eni.ludotheque.service;

import fr.eni.ludotheque.bo.Location;
import fr.eni.ludotheque.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository LocationRepository;

    public List<Location> getAll() {
        return LocationRepository.findAll();
    }

    public Location getById(Long locationId) {
        return LocationRepository.findById(locationId).orElse(null);
    }

    public Location create(Location location) {
        return LocationRepository.save(location);
    }

    public Location update(Location location) {
        return LocationRepository.save(location);
    }

    public void delete(Long locationId) {
        LocationRepository.deleteById(locationId);
    }

}
