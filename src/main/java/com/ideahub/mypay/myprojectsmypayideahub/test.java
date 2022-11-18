package com.ideahub.mypay.myprojectsmypayideahub;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Temporal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class test {

    @CreationTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateoperation = new java.sql.Timestamp(new java.util.Date().getTime());

    Random random = new Random();

    int rand = random.nextInt(999, 9999);

    public Date getDateoperation() {
        return dateoperation;
    }


    public static void main(String[] args) {

        test test = new test();

        System.out.println(test.dateoperation);

        System.out.println(test.rand);


        String formatDateTime =  LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        System.out.println("After Formatting: " + formatDateTime);

    }
}
