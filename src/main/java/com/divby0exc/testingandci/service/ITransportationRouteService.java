package com.divby0exc.testingandci.service;

import com.divby0exc.testingandci.handlerexception.*;
import com.divby0exc.testingandci.model.TransportationRoute;

import java.util.List;
import java.util.Optional;

public interface ITransportationRouteService {
    /*Update eventual discount*/

    TransportationRoute updateRouteDiscount(TransportationRoute transportationRoute) throws InvalidRouteIdException;

    /*Fetch a list of routes from all the contractors*/
    List<TransportationRoute> fetchAllRoutes() throws TransportationRoutesIsEmptyException;

    /*Create a new route*/
    TransportationRoute createNewRoute(TransportationRoute newRoute) throws InvalidArrivalPointInputException, InvalidDeparturePointInputException, InvalidTransportationCompanyInputException, InvalidEstimatedArrivalInputException, InvalidEstimatedDepartureInputException, InvalidTicketPriceInputException;

    /*Get one route by id*/
    Optional<TransportationRoute> getOneRoute(Long routeId) throws InvalidRouteIdException;
}
