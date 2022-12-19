package com.example.response;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class RestApiResponse<Τ> {

    private Τ account;
    private List<Τ> transactions = new ArrayList<>();
}
