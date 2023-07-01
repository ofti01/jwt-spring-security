package com.lotfi.jwtspringsecurity.payload.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomErrorResponse extends CustomResponse {
    private Map<String, String> errors;

    public CustomErrorResponse(HttpStatus status, Map<String, String> errors) {
        super(status);
        this.errors = errors;
    }

    public CustomErrorResponse(String message, HttpStatus status) {
        super(message, status);
    }
}
