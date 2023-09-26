package com.divby0exc.testingandci.service;

import com.divby0exc.testingandci.model.PaymentsHistory;

import java.util.Optional;

public interface IPaymentHistoryService {
    /*Fetch object*/
    Optional<PaymentsHistory> fetchPayment(Long accountId);

    PaymentsHistory createPayment(PaymentsHistory paymentsHistory);


}
