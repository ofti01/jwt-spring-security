package com.lotfi.jwtspringsecurity.payload.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class JwtResponse {
  private String access;
  private String type = "Bearer";
  private String refresh;
  private String username;
  private String email;
  private List<String> roles;

  public JwtResponse(String access, String refresh, String username, String email, List<String> roles) {
    this.access = access;
    this.refresh = refresh;
    this.username = username;
    this.email = email;
    this.roles = roles;
  }
}
