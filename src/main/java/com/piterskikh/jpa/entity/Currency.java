package com.piterskikh.jpa.entity;

import java.io.Serializable;

public class Currency implements Serializable {

    public static Currency getInstance(String currency) {
        return new Currency(currency);
    }

    private final String value;

    private Currency(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
