package com.divby0exc.testingandci.controller;

import com.divby0exc.testingandci.handlerexception.*;
import com.divby0exc.testingandci.model.TransportationRoute;
import com.divby0exc.testingandci.service.TransportationRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transportation/")
public class TransportationRouteController {
    @Autowired
    TransportationRouteService transportationRouteService;

    //    POST
    @PostMapping("create_route")
    public ResponseEntity<TransportationRoute> createRoute(@RequestBody TransportationRoute transportationRoute) throws InvalidEstimatedDepartureInputException, InvalidArrivalPointInputException, InvalidTransportationCompanyInputException, InvalidEstimatedArrivalInputException, InvalidDeparturePointInputException, InvalidTicketPriceInputException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(transportationRouteService.createNewRoute(transportationRoute));
    }

    //    GET
    @GetMapping("get_routes")
    public ResponseEntity<List<TransportationRoute>> fetchPayments() throws TransportationRoutesIsEmptyException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(transportationRouteService.fetchAllRoutes());
    }
    //    PUT
    @PutMapping("update_departure/{routeId}")
    public ResponseEntity<TransportationRoute> updateDeparture(@PathVariable Long routeId, @RequestBody TransportationRoute transportationRoute) throws InvalidRouteIdException, InvalidEstimatedDepartureInputException, InvalidArrivalPointInputException, InvalidTransportationCompanyInputException, InvalidEstimatedArrivalInputException, InvalidDeparturePointInputException, InvalidTicketPriceInputException {
        transportationRoute.setRouteId(routeId);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(transportationRouteService.updateRouteDiscount(transportationRoute));
    }
}
