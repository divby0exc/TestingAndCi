package com.divby0exc.testingandci.service;

import com.divby0exc.testingandci.model.TransportationRoute;

import java.util.List;

public interface ITransportationRouteService {
    /*Update eventual discount*/
    TransportationRoute updateRoute(Long accountId);

    /*Fetch a list of routes from all the contractors*/
    List<TransportationRoute> fetchAllRoutes();

    /*Create a new route*/
    TransportationRoute createNewRoute(TransportationRoute newRoute);

}
