package com.piterskikh.jpa.entity;


import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Address {

    //@NotNull
    //@Column(nullable = false)
    private String street;


   /* @NotNull
    @Column(nullable = false, length = 5)*/
    //@Convert(converter = ZipCodeConverter.class)
    private  ZipCode zipCode;

   /* @NotNull
    @Column(nullable = false)*/
    private String city;


    public Address() {

    }


    public Address(String street, ZipCode zipcode, String city) {
        this.street = street;
        this.zipCode = zipcode;
        this.city = city;
    }


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public ZipCode getZipcode() {
        return zipCode;
    }

    public void setZipcode(String zipcode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
