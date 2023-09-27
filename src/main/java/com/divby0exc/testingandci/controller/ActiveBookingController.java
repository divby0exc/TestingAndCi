package com.divby0exc.testingandci.controller;

import com.divby0exc.testingandci.handlerexception.InvalidBookingIdException;
import com.divby0exc.testingandci.model.ActiveBookings;
import com.divby0exc.testingandci.service.ActiveBookingService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ActiveBookings saveBooking(@RequestBody ActiveBookings activeBookings) {
        return activeBookingService.createNewBooking(activeBookings);
    }
    //    GET
    @GetMapping("get_booking/{accountId}")
    public Optional<ActiveBookings> fetchActiveBooking(@PathVariable Long accountId) throws InvalidBookingIdException {
        return activeBookingService.fetchOneBooking(accountId);
    }
    //    GET
    @GetMapping("get_booking_list/{accountId}")
    public List<ActiveBookings> fetchActiveBookingList(@PathVariable Long accountId) {
        return activeBookingService.fetchActiveBookingList(accountId);
    }
    //    Delete
    @DeleteMapping("delete_booking/{accountId}")
    public void deleteBooking(@PathVariable Long accountId) throws InvalidBookingIdException {
        activeBookingService.deleteBooking(accountId);
    }
}
