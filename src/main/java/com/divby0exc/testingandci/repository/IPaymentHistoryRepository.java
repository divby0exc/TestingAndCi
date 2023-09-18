package com.divby0exc.testingandci.repository;

import com.divby0exc.testingandci.model.PaymentsHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPaymentHistoryRepository extends JpaRepository<PaymentsHistory, Long> {
}
