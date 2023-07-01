package com.lotfi.jwtspringsecurity.payload.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomResponse {
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime timestamp = LocalDateTime.now();
    private String message;
    private Object data;

    public CustomResponse(String message, Object data, HttpStatus status) {
        this.message = message;
        this.data = data;
        this.status = status;
    }

    public CustomResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public CustomResponse(Object data, HttpStatus status) {
        this.data = data;
        this.status = status;
    }

    public CustomResponse(HttpStatus status) {
        this.status = status;
    }

    public CustomResponse(String message) {
        this.message = message;
    }
}