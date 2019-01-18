package com.piterskikh.jpa.entity;

import java.io.Serializable;

public class SimpleValue implements Serializable {

    private String value;

    public SimpleValue() {
    }

    public SimpleValue(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
