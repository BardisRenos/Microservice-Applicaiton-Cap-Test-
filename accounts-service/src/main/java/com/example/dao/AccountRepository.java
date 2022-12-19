package com.example.dao;

import com.example.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The Repository layer of Account
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Query(name = "select a from Account a where a.customerID = :id and a.transactionID is not null", nativeQuery=true)
    List<Account> findByCustomerID(Integer id);
}
