package com.divby0exc.testingandci.service;

import com.divby0exc.testingandci.model.ActiveBookings;
import com.divby0exc.testingandci.repository.IActiveBookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActiveBookingService
implements IActiveBookingService{
    @Autowired
    IActiveBookingsRepository repository;

    @Override
    public List<ActiveBookings> fetchActiveBookingList(Long accountId) {
        return null;
    }

    @Override
    public ActiveBookings createNewBooking(ActiveBookings activeBookings) {
        return repository.save(activeBookings);
    }

    @Override
    public void deleteBooking(Long bookingId) {

    }

    @Override
    public Optional<ActiveBookings> fetchOneBooking(Long accountId) {
        return repository.findById(accountId);
    }
}
