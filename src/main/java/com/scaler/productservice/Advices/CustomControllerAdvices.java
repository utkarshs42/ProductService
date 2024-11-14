package com.scaler.productservice.Advices;

import com.scaler.productservice.Dtos.errorDto;
import com.scaler.productservice.Exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomControllerAdvices {
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<errorDto> handleNPEException (){
        errorDto error = new errorDto();
        error.setMessage("Something went wrong");
        ResponseEntity<errorDto> responseEntity = new ResponseEntity<>
                (error, HttpStatusCode.valueOf(501));
        return responseEntity;
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<errorDto> handlePNFException(){
        errorDto error = new errorDto();
        error.setMessage("Product not found");
        ResponseEntity<errorDto> responseEntity = new ResponseEntity<>
                (error,HttpStatusCode.valueOf(404));
        return responseEntity;


    }
}
