package com.divby0exc.testingandci.service;

import com.divby0exc.testingandci.handlerexception.InvalidPaymentIdException;
import com.divby0exc.testingandci.model.PaymentsHistory;
import com.divby0exc.testingandci.repository.IPaymentHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentHistoryService
        implements IPaymentHistoryService {
    @Autowired
    IPaymentHistoryRepository repository;

    @Override
    public Optional<PaymentsHistory> fetchPayment(Long accountId) throws InvalidPaymentIdException {
        if (!repository.existsById(accountId))
            throw new InvalidPaymentIdException("No payment id found");
        return repository.findById(accountId);
    }

    @Override
    public PaymentsHistory createPayment(PaymentsHistory paymentsHistory) {
        return repository.save(paymentsHistory);
    }

    @Override
    public List<PaymentsHistory> fetchPaymentList(Long accountId) throws InvalidPaymentIdException {
        if (!repository.existsById(accountId))
            throw new InvalidPaymentIdException("Payment history id not found");
        return repository.findAll().stream().filter(e -> e.getAccountId().equals(accountId)).collect(Collectors.toList());
    }
}
