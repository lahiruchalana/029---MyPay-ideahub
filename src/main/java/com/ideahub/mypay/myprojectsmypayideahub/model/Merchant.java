package com.ideahub.mypay.myprojectsmypayideahub.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "merchant_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Merchant {

    @Id
    @SequenceGenerator(
            name = "merchant_sequence",
            sequenceName = "merchant_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "merchant_sequence"
    )
    private Long merchantId;
    private String name;
}
