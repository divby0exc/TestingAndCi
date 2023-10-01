package com.divby0exc.testingandci.controller;

import com.divby0exc.testingandci.handlerexception.InvalidAccountIdException;
import com.divby0exc.testingandci.handlerexception.InvalidRouteIdException;
import com.divby0exc.testingandci.model.ActiveBookings;
import com.divby0exc.testingandci.model.PaymentsHistory;
import com.divby0exc.testingandci.model.TransportationRoute;
import com.divby0exc.testingandci.service.AccountService;
import com.divby0exc.testingandci.service.ActiveBookingService;
import com.divby0exc.testingandci.service.PaymentHistoryService;
import com.divby0exc.testingandci.service.TransportationRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/book_a_ticket/")
public class TicketBookingController {
    @Autowired
    TransportationRouteService transportationRouteService;
    @Autowired
    ActiveBookingService activeBookingService;
    @Autowired
    PaymentHistoryService paymentHistoryService;
    @Autowired
    AccountService accountService;

    @PostMapping("{accountId}/{routeId}")
    public ResponseEntity<Optional<TransportationRoute>> buyATicket(@PathVariable Long routeId, @PathVariable Long accountId) throws InvalidRouteIdException, InvalidAccountIdException {
        ActiveBookings activeBookings = new ActiveBookings();
        PaymentsHistory paymentsHistory = new PaymentsHistory();
        if(accountService.fetchedAccount(accountId).isPresent()) {
            activeBookings.setAccountId(accountId);
            paymentsHistory.setAccountId(accountId);
        }
        if(transportationRouteService.getOneRoute(routeId).isPresent()) {
            activeBookings.setRouteId(routeId);
            paymentsHistory.setRouteId(routeId);
        }
        activeBookingService.createNewBooking(activeBookings);
        paymentHistoryService.createPayment(paymentsHistory);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(transportationRouteService.getOneRoute(routeId));
    }


}
