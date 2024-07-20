package com.kosta.ai;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {
    String street;
    String city;
    String state;
    String zipCode;
}