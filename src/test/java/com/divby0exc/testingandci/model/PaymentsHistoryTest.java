package com.divby0exc.testingandci.model;

import com.divby0exc.testingandci.TestingAndCiApplication;
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
    IPaymentHistoryRepository repo;

    @InjectMocks
    PaymentHistoryService paymentHistoryServiceWithMock;

    @Autowired
    PaymentHistoryService paymentHistoryService;

    @Test
    public void testThatInvalidPaymentIdIsNotThrown() {

    }

}