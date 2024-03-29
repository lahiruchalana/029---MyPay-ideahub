package com.ideahub.mypay.myprojectsmypayideahub.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DataExistingException extends RuntimeException{

    private String message;

    public DataExistingException(String message) {
        super(message);
        this.message =message;
    }

}
