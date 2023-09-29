package com.divby0exc.testingandci.service;

import com.divby0exc.testingandci.handlerexception.*;
import com.divby0exc.testingandci.model.TransportationRoute;
import com.divby0exc.testingandci.repository.ITransportationRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.util.TypeUtils.type;

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
    public TransportationRoute createNewRoute(TransportationRoute newRoute) throws InvalidArrivalPointInputException, InvalidDeparturePointInputException, InvalidTransportationCompanyInputException, InvalidEstimatedArrivalInputException, InvalidEstimatedDepartureInputException, InvalidTicketPriceInputException {
        if(newRoute.getArrivalPoint() == null) {
            throw new InvalidArrivalPointInputException("Arrival point cannot be null");
        } else if(newRoute.getArrivalPoint().isEmpty()) {
            throw new InvalidArrivalPointInputException("Arrival point cannot be empty");
        } else if(newRoute.getDeparturePoint() == null) {
            throw new InvalidDeparturePointInputException("Departure point cannot be null");
        } else if(newRoute.getDeparturePoint().isEmpty()) {
            throw new InvalidDeparturePointInputException("Departure point cannot be empty");
        } else if(newRoute.getTransportationCompany() == null) {
            throw new InvalidTransportationCompanyInputException("Transportation company cannot be null");
        } else if(newRoute.getTransportationCompany().isEmpty()) {
            throw new InvalidTransportationCompanyInputException("Transportation company cannot be empty");
        } else if(newRoute.getEstimatedArrival() == null) {
            throw new InvalidEstimatedArrivalInputException("Estimated arrival cannot be null");
        } else if(newRoute.getEstimatedArrival().isEmpty()) {
            throw new InvalidEstimatedArrivalInputException("Estimated arrival cannot be empty");
        } else if(newRoute.getEstimatedDeparture() == null) {
            throw new InvalidEstimatedDepartureInputException("Estimated departure cannot be null");
        } else if(newRoute.getEstimatedDeparture().isEmpty()) {
            throw new InvalidEstimatedDepartureInputException("Estimated departure cannot be empty");
        } else if(newRoute.getTicketPrice() <= 0) {
            throw new InvalidTicketPriceInputException("Ticket price needs to have an actual price that you can pay");
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


