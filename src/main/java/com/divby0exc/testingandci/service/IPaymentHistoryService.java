package com.divby0exc.testingandci.service;

import com.divby0exc.testingandci.handlerexception.InvalidPaymentIdException;
import com.divby0exc.testingandci.model.PaymentsHistory;

import java.util.List;
import java.util.Optional;

public interface IPaymentHistoryService {

    PaymentsHistory createPayment(PaymentsHistory paymentsHistory);


}
