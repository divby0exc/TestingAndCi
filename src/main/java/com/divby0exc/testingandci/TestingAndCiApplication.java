package com.divby0exc.testingandci;

import com.divby0exc.testingandci.model.Account;
import com.divby0exc.testingandci.service.AccountService;
import com.divby0exc.testingandci.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestingAndCiApplication {


    public static void main(String[] args) {
        SpringApplication.run(TestingAndCiApplication.class, args);
    }

}
