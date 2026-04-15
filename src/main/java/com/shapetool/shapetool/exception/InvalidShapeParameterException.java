package com.shapetool.shapetool.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CLIENT)
public class InvalidShapeParameterException extends RuntimeException {

    public InvalidShapeParameterException(String message) {
        super(message);
    }
}