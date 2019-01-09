package com.techdialogue.reactive.stock_trader.alphavantage;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class Crypto {
    String name;
    String currencyCode;
    BigDecimal exchangeRate;
    ZonedDateTime dateTime;

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public void setDateTime(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
    }

}
