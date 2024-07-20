package com.kosta.ai;

import lombok.Data;
import jakarta.persistence.Embeddable;
import java.math.BigDecimal;

@Data
@Embeddable
public class Money {
    BigDecimal amount;
    String currency;
}