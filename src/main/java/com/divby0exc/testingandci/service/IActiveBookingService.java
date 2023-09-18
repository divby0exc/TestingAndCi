package com.divby0exc.testingandci.service;

import com.divby0exc.testingandci.model.ActiveBookings;

public interface IActiveBookingService {
    /*Fetch object*/
    ActiveBookings fetchActiveBookingList(Long accountId);

    /*Create new booking*/
    ActiveBookings createNewBooking(ActiveBookings activeBookings);

    /*Delete a booking*/
    void deleteBooking(Long bookingId);
}
