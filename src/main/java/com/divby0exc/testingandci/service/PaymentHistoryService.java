package com.divby0exc.testingandci.service;

import com.divby0exc.testingandci.model.PaymentsHistory;
import com.divby0exc.testingandci.repository.IPaymentHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentHistoryService
implements IPaymentHistoryService{
    @Autowired
    IPaymentHistoryRepository repository;

    @Override
    public PaymentsHistory paymentHistory(Long accountId) {
        return null;
    }
}
