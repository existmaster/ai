package com.kosta.ai;

import lombok.Value;
import jakarta.persistence.Embeddable;
import java.math.BigDecimal;

@Value
@Embeddable
public class Money {
    BigDecimal amount;
    String currency;
}