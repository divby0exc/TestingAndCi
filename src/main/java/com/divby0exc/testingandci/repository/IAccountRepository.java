package com.divby0exc.testingandci.repository;

import com.divby0exc.testingandci.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountRepository extends JpaRepository<Account, Long> {
}
