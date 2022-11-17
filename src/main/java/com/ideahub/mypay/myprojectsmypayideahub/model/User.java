package com.ideahub.mypay.myprojectsmypayideahub.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long userId;
    private Integer phoneNumber;
    private String userName;
    private String email;
    private String password;
    private String name;
    private String nic;
    private String qOneAnswer;
    private String qSecondAnswer;
    private String qThirdAnswer;

}
