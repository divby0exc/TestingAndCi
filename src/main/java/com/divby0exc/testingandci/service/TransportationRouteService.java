package com.divby0exc.testingandci.service;

import com.divby0exc.testingandci.handlerexception.InvalidArrivalPointInputException;
import com.divby0exc.testingandci.handlerexception.InvalidDeparturePointInputException;
import com.divby0exc.testingandci.handlerexception.InvalidRouteIdException;
import com.divby0exc.testingandci.handlerexception.TransportationRoutesIsEmptyException;
import com.divby0exc.testingandci.model.TransportationRoute;
import com.divby0exc.testingandci.repository.ITransportationRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransportationRouteService implements ITransportationRouteService {
    @Autowired
    ITransportationRouteRepository repository;

    @Override
    public TransportationRoute updateRouteDiscount(TransportationRoute transportationRoute) throws InvalidRouteIdException {
        if(!repository.existsById(transportationRoute.getRouteId()))
            throw new InvalidRouteIdException("The given route ID was not found");
        return createNewRoute(transportationRoute);
    }

    @Override
    public List<TransportationRoute> fetchAllRoutes() throws TransportationRoutesIsEmptyException {
        if(repository.findAll().isEmpty())
            throw new TransportationRoutesIsEmptyException("Route list is empty");
        return repository.findAll();
    }

    @Override
    public TransportationRoute createNewRoute(TransportationRoute newRoute) throws InvalidArrivalPointInputException, InvalidDeparturePointInputException {
        if(newRoute.getArrivalPoint() == null) {
            throw new InvalidArrivalPointInputException("Arrival point cannot be null");
        } else if(newRoute.getArrivalPoint().isEmpty()) {
            throw new InvalidArrivalPointInputException("Arrival point cannot be empty");
        } else if(newRoute.getDeparturePoint() == null) {
            throw new InvalidDeparturePointInputException("Departure point cannot be null");
        } else if(newRoute.getDeparturePoint().isEmpty()) {
            throw new InvalidDeparturePointInputException("Departure point cannot be empty");
        }
        return repository.save(newRoute);
    }

    @Override
    public Optional<TransportationRoute> getOneRoute(Long routeId) throws InvalidRouteIdException {
        if(!repository.existsById(routeId))
            throw new InvalidRouteIdException("The given route ID was not found");

        return repository.findById(routeId);
    }
}


