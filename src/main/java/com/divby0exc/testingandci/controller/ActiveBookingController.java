package com.divby0exc.testingandci.controller;

import com.divby0exc.testingandci.handlerexception.InvalidBookingIdException;
import com.divby0exc.testingandci.model.ActiveBookings;
import com.divby0exc.testingandci.service.ActiveBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/activebooking/")
public class ActiveBookingController {
    @Autowired
    private ActiveBookingService activeBookingService;


    //    POST
    @PostMapping("create_booking")
    public ResponseEntity<ActiveBookings> saveBooking(@RequestBody ActiveBookings activeBookings) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                        .body(activeBookingService.createNewBooking(activeBookings));
    }
    //    GET
    @GetMapping("get_booking/{bookingId}")
    public ResponseEntity<Optional<ActiveBookings>> fetchActiveBooking(@PathVariable Long bookingId) throws InvalidBookingIdException {
        return ResponseEntity
                .status(HttpStatus.OK)
                        .body(activeBookingService.fetchOneBooking(bookingId));
    }
    //    GET
    @GetMapping("get_booking_list/{accountId}")
    public ResponseEntity<List<ActiveBookings>> fetchActiveBookingList(@PathVariable Long accountId) throws InvalidBookingIdException {
        return ResponseEntity
                .status(HttpStatus.OK)
                        .body(activeBookingService.fetchActiveBookingList(accountId));
    }
    //    Delete
    @DeleteMapping("delete_booking/{bookingId}")
    public ResponseEntity<HttpStatus> deleteBooking(@PathVariable Long bookingId) throws InvalidBookingIdException {
        activeBookingService.deleteBooking(bookingId);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                        .build();
    }
}
