package com.divby0exc.testingandci.model;

import com.divby0exc.testingandci.TestingAndCiApplication;
import com.divby0exc.testingandci.repository.IPaymentHistoryRepository;
import com.divby0exc.testingandci.service.PaymentHistoryService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {TestingAndCiApplication.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class PaymentsHistoryTest {

    @Mock
    private IPaymentHistoryRepository paymentsHistoryRepository;

    @InjectMocks
    private PaymentHistoryService mockedService;

    @Test
    public void testThatNoExceptionsIsThrownWhenPaymentsHistoryIsCreated() {
        PaymentsHistory paymentsHistory = new PaymentsHistory();
        paymentsHistory.setRouteId(1L);
        paymentsHistory.setAccountId(1L);

        assertDoesNotThrow(() -> mockedService.createPayment(paymentsHistory));
    }

}