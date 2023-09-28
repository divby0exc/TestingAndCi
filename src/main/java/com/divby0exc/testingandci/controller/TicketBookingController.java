package com.divby0exc.testingandci.controller;

import com.divby0exc.testingandci.handlerexception.InvalidRouteIdException;
import com.divby0exc.testingandci.model.ActiveBookings;
import com.divby0exc.testingandci.model.PaymentsHistory;
import com.divby0exc.testingandci.model.TransportationRoute;
import com.divby0exc.testingandci.service.AccountService;
import com.divby0exc.testingandci.service.ActiveBookingService;
import com.divby0exc.testingandci.service.PaymentHistoryService;
import com.divby0exc.testingandci.service.TransportationRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book_a_ticket/")
public class TicketBookingController {
    @Autowired
    TransportationRouteService transportationRouteService;
    @Autowired
    ActiveBookingService activeBookingService;
    @Autowired
    PaymentHistoryService paymentHistoryService;

    @PostMapping("{routeId}")
    public TransportationRoute buyATicket(@PathVariable Long routeId,
                                          @RequestBody ActiveBookings activeBookings,
                                          @RequestBody PaymentsHistory paymentsHistory) throws InvalidRouteIdException {
        activeBookingService.createNewBooking(activeBookings);
        paymentHistoryService.createPayment(paymentsHistory);
        return transportationRouteService.getOneRoute(routeId);
    }


}
