package com.ideahub.mypay.myprojectsmypayideahub.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "otp_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OTP {

    @Id
    @SequenceGenerator(
            name = "otp_sequence",
            sequenceName = "otp_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "otp_sequence"
    )
    private Long otpId;
    private Integer otpValue;
    @CreationTimestamp
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date currentTime = new java.sql.Timestamp(new java.util.Date().getTime());

    @OneToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "userId"
    )
    private User user;

    public OTP(Integer otpValue, User user) {
        this.otpValue = otpValue;
        this.user = user;
    }
}
