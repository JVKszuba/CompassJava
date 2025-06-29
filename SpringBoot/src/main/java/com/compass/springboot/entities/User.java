package com.compass.springboot.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cellphone;
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    public User() {}
    public User(Long id, String name, String email, String cellphone, String password) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.cellphone = cellphone;
        this.password = password;
    }

    public Long getId() {return id;}
    public String getName() {return name;}
    public String getEmail() {return email;}
    public String getCellphone() {return cellphone;}
    public String getPassword() {return password;}
    public List<Order> getOrders() {return orders;}

    public void setId(Long id) {this.id = id;}
    public void setName(String name) {this.name = name;}
    public void setEmail(String email) {this.email = email;}
    public void setCellphone(String cellphone) {this.cellphone = cellphone;}
    public void setPassword(String password) {this.password = password;}

    @Override
    public boolean equals(Object o) {

        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {

        return Objects.hashCode(id);
    }
}
