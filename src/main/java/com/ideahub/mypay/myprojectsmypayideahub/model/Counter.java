package com.ideahub.mypay.myprojectsmypayideahub.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "counter_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Counter {

    @Id
    @SequenceGenerator(
            name = "counter_sequence",
            sequenceName = "counter_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "counter_sequence"
    )
    private Long counterId;
    private Integer qrCodeId;

    @OneToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "outlet_id",
            referencedColumnName = "outletId"
    )
    private Outlet outlet;
}
