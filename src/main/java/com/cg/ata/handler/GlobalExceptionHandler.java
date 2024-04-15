package com.cg.ata.handler;

import com.cg.ata.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(
            {
               VehicleNotFoundException.class,
               RouteNotFoundException.class,
               DriverNotFoundException.class,
               BookingNotFoundException.class,
               UserNotFoundException.class
            })
    public ResponseEntity<Object> handleNotFoundException(Exception ex) {
        ApiError error = new ApiError();
        error.setStatus(HttpStatus.BAD_REQUEST);
        error.setTimestamp(LocalDateTime.now());
        error.setMessage(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.valueOf(400));
    }
}
