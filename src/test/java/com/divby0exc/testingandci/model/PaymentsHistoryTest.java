package com.divby0exc.testingandci.model;

import com.divby0exc.testingandci.TestingAndCiApplication;
import com.divby0exc.testingandci.handlerexception.InvalidPaymentIdException;
import com.divby0exc.testingandci.repository.IPaymentHistoryRepository;
import com.divby0exc.testingandci.service.PaymentHistoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {TestingAndCiApplication.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ExtendWith(MockitoExtension.class)
class PaymentsHistoryTest {

    @Mock
    private IPaymentHistoryRepository repo;

    @InjectMocks
    private PaymentHistoryService mockedService;

    @Autowired
    private PaymentHistoryService paymentService;

    @Test
    public void testThatNoExceptionsIsThrownWhenPaymentsHistoryIsCreated() {
        PaymentsHistory paymentsHistory = new PaymentsHistory();
        paymentsHistory.setRouteId(1L);
        paymentsHistory.setAccountId(1L);

        assertDoesNotThrow(() -> mockedService.createPayment(paymentsHistory));
    }

    @Test
    public void testThatNoExceptionIsThrownWhenPaymentIsFetched() throws InvalidPaymentIdException {
        PaymentsHistory paymentsHistory = new PaymentsHistory();
        paymentsHistory.setRouteId(1L);
        paymentsHistory.setAccountId(1L);

        paymentService.createPayment(paymentsHistory);

        assertTrue(mockedService.fetchPayment(1L).isPresent());
    }

}