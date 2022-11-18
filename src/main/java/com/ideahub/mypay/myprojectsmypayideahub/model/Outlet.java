package com.ideahub.mypay.myprojectsmypayideahub.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "outlet_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Outlet {

    @Id
    @SequenceGenerator(
            name = "outlet_sequence",
            sequenceName = "outlet_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "outlet_sequence"
    )
    private Long outletId;
    private String name;

    @OneToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "merchant_id",
            referencedColumnName = "merchantId"
    )
    private Merchant merchant;

}
