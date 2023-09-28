package com.divby0exc.testingandci.service;

import com.divby0exc.testingandci.handlerexception.InvalidBookingIdException;
import com.divby0exc.testingandci.model.ActiveBookings;

import java.util.List;
import java.util.Optional;

public interface IActiveBookingService {
    /*Fetch object list*/
    List<ActiveBookings> fetchActiveBookingList(Long accountId) throws InvalidBookingIdException;

    /*Create new booking*/
    ActiveBookings createNewBooking(ActiveBookings activeBookings);

    /*Delete a booking*/
    void deleteBooking(Long bookingId) throws InvalidBookingIdException;

    Optional<ActiveBookings> fetchOneBooking(Long accountId) throws InvalidBookingIdException;
}
