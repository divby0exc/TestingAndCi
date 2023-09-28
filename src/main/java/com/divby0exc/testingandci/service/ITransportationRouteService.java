package com.divby0exc.testingandci.service;

import com.divby0exc.testingandci.handlerexception.InvalidRouteIdException;
import com.divby0exc.testingandci.model.TransportationRoute;

import java.util.List;

public interface ITransportationRouteService {
    /*Update eventual discount*/

    TransportationRoute updateRouteDiscount(TransportationRoute transportationRoute) throws InvalidRouteIdException;

    /*Fetch a list of routes from all the contractors*/
    List<TransportationRoute> fetchAllRoutes();

    /*Create a new route*/
    TransportationRoute createNewRoute(TransportationRoute newRoute);

    /*Get one route by id*/
    TransportationRoute getOneRoute(Long routeId) throws InvalidRouteIdException;
}
