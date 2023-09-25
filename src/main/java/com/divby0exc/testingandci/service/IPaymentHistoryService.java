package com.divby0exc.testingandci.service;

import com.divby0exc.testingandci.model.PaymentsHistory;

public interface IPaymentHistoryService {
    /*Fetch object*/
    PaymentsHistory fetchPayment(Long accountId);

    PaymentsHistory createPayment(PaymentsHistory paymentsHistory);


}
