package com.example.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;



@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @JsonProperty("customer_id")
    private Integer customerID;
    private String name;
    private String surname;
    private Integer balance;
}
