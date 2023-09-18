package com.divby0exc.testingandci.service;

import com.divby0exc.testingandci.repository.IActiveBookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActiveBookingService {
    @Autowired
    IActiveBookingsRepository repository;
}
