package com.divby0exc.testingandci.controller;

import com.divby0exc.testingandci.model.PaymentsHistory;
import com.divby0exc.testingandci.service.PaymentHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/paymenthistory/")
public class PaymentHistoryController {
    @Autowired
    PaymentHistoryService paymentHistoryService;

    //    POST
    @PostMapping("create_payment")
    public PaymentsHistory savePayment(@RequestBody PaymentsHistory paymentsHistory) {
        return paymentHistoryService.createPayment(paymentsHistory);
    }
    //    GET
    @GetMapping("get_payment/{accountId}")
    public Optional<PaymentsHistory> fetchActiveBooking(@PathVariable Long accountId) {
        return paymentHistoryService.fetchPayment(accountId);
    }
}
