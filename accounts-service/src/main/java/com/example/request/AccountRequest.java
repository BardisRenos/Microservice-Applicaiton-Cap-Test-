package com.example.request;


import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;

/**
 * The request class for a new current account.
 */
@Getter
@Setter
@Builder
public class AccountRequest {

    @NotNull
    private Integer customerID;
    @NotNull
    @Min(value = 0, message = "Initial Credit value must not be negative value")
    private Integer initialCredit;
}
