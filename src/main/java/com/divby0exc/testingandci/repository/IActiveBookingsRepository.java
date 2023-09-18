package com.divby0exc.testingandci.repository;

import com.divby0exc.testingandci.model.ActiveBookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActiveBookingsRepository extends JpaRepository<ActiveBookings, Long> {
}
