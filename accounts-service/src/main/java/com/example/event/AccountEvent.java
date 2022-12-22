package com.example.event;

import com.example.response.Transaction;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountEvent<T> {

    private T accountId;
    private T status;
    private Transaction transaction;
}
