package com.piterskikh.jpa.entity;


import java.io.Serializable;
import java.math.BigDecimal;


public class MonetaryAmount implements Serializable {

    private final BigDecimal value;
    private final Currency currency;

    private MonetaryAmount(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final MonetaryAmount monetaryAmount = (MonetaryAmount) o;
        if(!value.equals((monetaryAmount.value))) return false;
        return currency.equals((monetaryAmount.currency));
    }

    @Override
    public int hashCode() {
        int result;
        result = value.hashCode();
        result = 29 * result + currency.hashCode();
        return result;

    }

    @Override
    public String toString() {
        return getValue() + " " + getCurrency();
    }


    public static MonetaryAmount fromString(String s){

        String[] split = s.split(" ");
        return new MonetaryAmount(new BigDecimal(split[0]), Currency.getInstance(split[1]));
    }
}
