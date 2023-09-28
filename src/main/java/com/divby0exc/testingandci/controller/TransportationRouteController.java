package com.divby0exc.testingandci.controller;

import com.divby0exc.testingandci.handlerexception.InvalidRouteIdException;
import com.divby0exc.testingandci.model.TransportationRoute;
import com.divby0exc.testingandci.service.TransportationRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transportation/")
public class TransportationRouteController {
    @Autowired
    TransportationRouteService transportationRouteService;

    //    POST
    @PostMapping("create_route")
    public TransportationRoute createRoute(@RequestBody TransportationRoute transportationRoute) {
        return transportationRouteService.createNewRoute(transportationRoute);
    }

    //    GET
    @GetMapping("get_routes")
    public List<TransportationRoute> fetchPayments() {
        return transportationRouteService.fetchAllRoutes();
    }
    //    PUT
    @PutMapping("update_departure/{routeId}")
    public TransportationRoute updateDeparture(@PathVariable Long routeId, @RequestBody TransportationRoute transportationRoute) throws InvalidRouteIdException {
        transportationRoute.setRouteId(routeId);
        return transportationRouteService.updateRouteDiscount(transportationRoute);
    }
}
