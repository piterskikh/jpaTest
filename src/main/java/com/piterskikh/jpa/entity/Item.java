package com.piterskikh.jpa.entity;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Entity
//@Table(name = "\"ITEMS\"")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @NotNull
    @Column(nullable = false, columnDefinition="Varchar(100) default 'start'")
    private String text = "stop";


    @Temporal(TemporalType.TIMESTAMP)
    //@UpdateTimestamp
    @Column(insertable = false, updatable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Generated(GenerationTime.INSERT)
    private Date createdTime;


    @Temporal(TemporalType.TIMESTAMP)
    //@UpdateTimestamp
    @Column(insertable = false, updatable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Generated(GenerationTime.INSERT)
    private Date LastModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getLastModified() {
        return LastModified;
    }

    public void setLastModified(Date lastMoifed) {
        this.LastModified = lastMoifed;
    }
}
