package com.lotfi.jwtspringsecurity.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
	@NotBlank(message = "please enter your username")
  private String username;

	@NotBlank(message = "please enter your password")
	private String password;
}
