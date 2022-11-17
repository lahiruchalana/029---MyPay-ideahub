package com.ideahub.mypay.myprojectsmypayideahub.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.Temporal;
import java.util.Date;

public class test {

    @CreationTimestamp
    @Generated(GenerationTime.ALWAYS)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateoperation = new java.sql.Timestamp(new java.util.Date().getTime());

    public Date getDateoperation() {
        return dateoperation;
    }

    public static void main(String[] args) {

        test test = new test();

        System.out.println(test.dateoperation);

    }
}
