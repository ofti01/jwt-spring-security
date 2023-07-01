package com.lotfi.jwtspringsecurity.payload.request;

import java.util.Set;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {
  @NotBlank(message = "Username must be not empty")
  @Size(min=3, message = "Name should be atleast 3 characters")
  @Size(max=20, message = "Name should not be greater than 20 characters")
  private String username;

  @NotBlank(message = "email must be not empty")
  @Size(max=50, message = "Name should not be greater than 50 characters")
  @Email(message = "Please enter a valid email Id", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
  private String email;

  private Set<String> role;

  @NotBlank(message = "password must be not empty")
  @Size(min=6, message = "Name should be atleast 6 characters")
  @Size(max=40, message = "Name should not be greater than 40 characters")
  private String password;

}
