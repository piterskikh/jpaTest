package com.piterskikh.jpa.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class SimpleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Column(name = "doc_number", columnDefinition = "varchar2(20)")

    private SimpleValue simpleValue;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SimpleValue getSimpleValue() {
        return simpleValue;
    }

    public void setSimpleValue(SimpleValue simpleValue) {
        this.simpleValue = simpleValue;
    }
}
