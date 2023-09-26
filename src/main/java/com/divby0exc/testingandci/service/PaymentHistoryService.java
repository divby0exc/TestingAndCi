package com.divby0exc.testingandci.service;

import com.divby0exc.testingandci.model.PaymentsHistory;
import com.divby0exc.testingandci.repository.IPaymentHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentHistoryService
implements IPaymentHistoryService{
    @Autowired
    IPaymentHistoryRepository repository;

    @Override
    public Optional<PaymentsHistory> fetchPayment(Long accountId) {
        return repository.findById(accountId);
    }

    @Override
    public PaymentsHistory createPayment(PaymentsHistory paymentsHistory) {
        return repository.save(paymentsHistory);
    }
}
