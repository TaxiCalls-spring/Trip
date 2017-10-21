package com.taxicalls.trip.service;

import com.taxicalls.trip.model.Trip;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.taxicalls.trip.repository.TripRepository;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author romulo
 */
@Service
public class TripService {

    protected static final Logger LOGGER = Logger.getLogger(TripService.class.getName());

    protected TripRepository tripRepository;

    @Autowired
    public TripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
        LOGGER.log(Level.INFO, "TripRepository says system has {0} ", tripRepository.count());
    }

    public Trip createTrip(Trip trip) {
        Trip save = tripRepository.save(trip);
        return save;
    }

    public List<Trip> getTrips() {
        List<Trip> trips = new ArrayList<>();
        Iterable<Trip> findAll = tripRepository.findAll();
        for (Trip trip : findAll) {
            trips.add(trip);
        }
        return trips;
    }

    public Trip getTrip(Integer id) {
        return tripRepository.findOne(id);
    }

}