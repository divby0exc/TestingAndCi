package com.divby0exc.testingandci.model;

import com.divby0exc.testingandci.TestingAndCiApplication;
import com.divby0exc.testingandci.handlerexception.InvalidPaymentIdException;
import com.divby0exc.testingandci.repository.IPaymentHistoryRepository;
import com.divby0exc.testingandci.service.PaymentHistoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;

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

    private PaymentsHistory paymentsHistory = new PaymentsHistory();
    private PaymentsHistory paymentsHistory2 = new PaymentsHistory();
    private PaymentsHistory paymentsHistory3 = new PaymentsHistory();

    @BeforeEach
    void init() {
        paymentsHistory.setRouteId(1L);
        paymentsHistory.setAccountId(1L);
        paymentsHistory2.setRouteId(2L);
        paymentsHistory2.setAccountId(1L);
        paymentsHistory3.setRouteId(3L);
        paymentsHistory3.setAccountId(1L);

        paymentService.createPayment(paymentsHistory);
        paymentService.createPayment(paymentsHistory2);
        paymentService.createPayment(paymentsHistory3);
    }

    @Test
    public void testThatNoExceptionsIsThrownWhenPaymentsHistoryIsCreated() {
        assertDoesNotThrow(() -> mockedService.createPayment(paymentsHistory));
    }

    @Test
    public void testThatNoExceptionIsThrownWhenPaymentIsFetched() throws InvalidPaymentIdException {
        assertTrue(paymentService.fetchPayment(1L).isPresent());
    }

    @Test
    public void testThatNoExceptionIsThrownWhenPaymentListIsFetched() throws InvalidPaymentIdException {
        List<PaymentsHistory> list = new ArrayList<>(paymentService.fetchPaymentList(1L));

        assertDoesNotThrow(() -> paymentService.fetchPaymentList(1L));
        assertEquals(3, list.size());
    }

}