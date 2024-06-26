package com.sptek.webflux.customer;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

@RequiredArgsConstructor
@Data
public class Customer {

    @Id
    private Long id;
    private final String firstName;
    private final String lastName;

}
