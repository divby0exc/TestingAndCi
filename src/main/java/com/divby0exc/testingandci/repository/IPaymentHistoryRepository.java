package com.divby0exc.testingandci.repository;

import com.divby0exc.testingandci.model.PaymentsHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentHistoryRepository extends JpaRepository<PaymentsHistory, Long> {
}
