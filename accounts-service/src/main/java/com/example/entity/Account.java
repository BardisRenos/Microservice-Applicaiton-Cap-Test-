package com.example.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * The entity class of the Account database table
 */
@Getter
@Setter
//@Builder
@NoArgsConstructor
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue
//    @Column(name = "account_id", unique = true, nullable = false, updatable = false)
    private Integer accountID;
    @Column(name = "initial_credit")
    private Integer initialCredit;
    @Column(name = "date_creation")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dateCreation;

    @Column(name = "customer_id")
    private Integer customerID;

    @Column(name = "transaction_id")
    private Integer transactionID;

    public Account(Integer accountID, Integer initialCredit, LocalDateTime dateCreation, Integer customerID, Integer transactionID) {
        this.accountID = accountID;
        this.initialCredit = initialCredit;
        this.dateCreation = dateCreation;
        this.customerID = customerID;
        this.transactionID = transactionID;
    }
}
