package com.divby0exc.testingandci.service;

import com.divby0exc.testingandci.handlerexception.InvalidArrivalPointInputException;
import com.divby0exc.testingandci.handlerexception.InvalidDeparturePointInputException;
import com.divby0exc.testingandci.handlerexception.InvalidRouteIdException;
import com.divby0exc.testingandci.handlerexception.TransportationRoutesIsEmptyException;
import com.divby0exc.testingandci.model.TransportationRoute;

import java.util.List;
import java.util.Optional;

public interface ITransportationRouteService {
    /*Update eventual discount*/

    TransportationRoute updateRouteDiscount(TransportationRoute transportationRoute) throws InvalidRouteIdException;

    /*Fetch a list of routes from all the contractors*/
    List<TransportationRoute> fetchAllRoutes() throws TransportationRoutesIsEmptyException;

    /*Create a new route*/
    TransportationRoute createNewRoute(TransportationRoute newRoute) throws InvalidArrivalPointInputException, InvalidDeparturePointInputException;

    /*Get one route by id*/
    Optional<TransportationRoute> getOneRoute(Long routeId) throws InvalidRouteIdException;
}
