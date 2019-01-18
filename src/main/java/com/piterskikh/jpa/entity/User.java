package com.piterskikh.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


   // private Address homeAddress;


   /* @AttributeOverrides({@AttributeOverride(name = "street", column = @Column(name = "billing_street")),
            @AttributeOverride(name = "zipcode", column = @Column(name = "billing_zipcode")),
            @AttributeOverride(name = "city", column = @Column(name = "billing_city"))
    })
    private Address billingAddress;*/

    public Long getId() {
        return id;
    }


    /*public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }*/

   /* public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }*/
}
