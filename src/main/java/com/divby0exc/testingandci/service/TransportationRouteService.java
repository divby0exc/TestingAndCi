package com.divby0exc.testingandci.service;

import com.divby0exc.testingandci.handlerexception.InvalidRouteIdException;
import com.divby0exc.testingandci.model.TransportationRoute;
import com.divby0exc.testingandci.repository.ITransportationRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<TransportationRoute> fetchAllRoutes() {
        return repository.findAll();
    }

    @Override
    public TransportationRoute createNewRoute(TransportationRoute newRoute) {
        return repository.save(newRoute);
    }
}
