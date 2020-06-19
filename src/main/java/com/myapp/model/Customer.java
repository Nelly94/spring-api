package com.myapp.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.myapp.config.JsonPropertyView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonPropertyView.Customer.class)
    private long id;

    @JsonView(JsonPropertyView.Customer.class)
    private String firstName;

    @JsonView(JsonPropertyView.Customer.class)
    private String lastName;

    @JsonView(JsonPropertyView.Customer.class)
    @ManyToMany
    private List<Product> productList = new ArrayList<>();

    public Customer(){

    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
