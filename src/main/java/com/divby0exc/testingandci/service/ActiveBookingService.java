package com.divby0exc.testingandci.service;

import com.divby0exc.testingandci.handlerexception.InvalidAccountIdException;
import com.divby0exc.testingandci.handlerexception.InvalidBookingIdException;
import com.divby0exc.testingandci.model.ActiveBookings;
import com.divby0exc.testingandci.repository.IActiveBookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActiveBookingService
implements IActiveBookingService{
    @Autowired
    IActiveBookingsRepository repository;

    @Override
    public List<ActiveBookings> fetchActiveBookingList(Long accountId) throws InvalidBookingIdException {
        if(!repository.existsByAccountId(accountId))
            throw new InvalidBookingIdException("Booking id not found");
        return repository.findAll().stream().filter(e -> e.getAccountId().equals(accountId)).collect(Collectors.toList());
    }

    @Override
    public List<ActiveBookings> fetchBookingList() {
        return repository.findAll();
    }

    @Override
    public ActiveBookings createNewBooking(ActiveBookings activeBookings) {
        return repository.save(activeBookings);
    }

    @Override
    public void deleteBooking(Long bookingId) throws InvalidBookingIdException {
        if(!repository.existsById(bookingId))
            throw new InvalidBookingIdException("Booking id not found");
        repository.deleteById(bookingId);
    }

    @Override
    public Optional<ActiveBookings> fetchOneBooking(Long bookingId) throws InvalidBookingIdException {
        if(!repository.existsById(bookingId))
            throw new InvalidBookingIdException("Booking id not found");
        return repository.findById(bookingId);
    }

}
