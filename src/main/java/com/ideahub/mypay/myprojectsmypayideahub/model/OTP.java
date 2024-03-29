package com.ideahub.mypay.myprojectsmypayideahub.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime = LocalDateTime.now();

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
