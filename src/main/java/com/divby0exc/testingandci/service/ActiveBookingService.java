package com.divby0exc.testingandci.service;

import com.divby0exc.testingandci.model.ActiveBookings;
import com.divby0exc.testingandci.repository.IActiveBookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActiveBookingService
implements IActiveBookingService{
    @Autowired
    IActiveBookingsRepository repository;

    @Override
    public ActiveBookings fetchActiveBookingList(Long accountId) {
        return null;
    }

    @Override
    public ActiveBookings createNewBooking(ActiveBookings activeBookings) {
        return null;
    }

    @Override
    public void deleteBooking(Long bookingId) {

    }
}
