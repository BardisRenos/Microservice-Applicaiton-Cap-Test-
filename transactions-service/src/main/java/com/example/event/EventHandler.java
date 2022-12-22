package com.example.event;

import com.example.entity.Transaction;
import com.example.service.Interfaces.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EventHandler {

    public static final String QUEUE = "account_queue";

    private TransactionService transactionService;

    public EventHandler(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @RabbitListener(queues = QUEUE)
    public void handleCustomerEvent(final TransactionEvent transactionEvent) {
        log.info("A transaction event received the account of: {}", transactionEvent.getAccountId());
        try {
            if (transactionEvent.getStatus().equals("CREATED")) {
                Transaction transaction = transactionEvent.getTransaction();

                log.info("Write a Transaction entity into database table");
                transactionService.addTransaction(transaction);
            }
        } catch (Exception ex) {
            throw new AmqpRejectAndDontRequeueException(ex);
        }
    }

}
