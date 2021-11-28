package com.movieminers.moviemine.authority;

import javax.persistence.*;

@Entity
@Table(name = "AUTHORITIES")
public class Authority {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String username;
  private String authority;

  public Authority() {
  }

  public Authority(String username, String authority) {
    this.username = username;
    this.authority = authority;
  }

  // Getters and setters

  public String getUsername() {
    return username;
  }

  public String getAuthority() {
    return authority;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void getAuthority(String authority) {
    this.authority = authority;
  }
}
