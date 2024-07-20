package com.kosta.ai;

import jakarta.persistence.Embeddable;
import lombok.Value;

@Value
@Embeddable
public class Address {
    String street;
    String city;
    String state;
    String zipCode;
}