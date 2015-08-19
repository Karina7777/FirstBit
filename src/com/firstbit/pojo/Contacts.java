package com.firstbit.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Contacts {

  @Column(name="id")
  @Id
  @GeneratedValue
  private int id;
  
  @Column(name="name")
  private String name;
  
  @Column(name="email")
  private String email;
  
  @Column(name="telephone")
  private String telephone;
  
  @ManyToOne(cascade=CascadeType.ALL)
  @JoinColumn(name="id_user")
  private Users user;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public Users getUser() {
    return user;
  }

  public void setUser(Users user) {
    this.user = user;
  }
  
}
