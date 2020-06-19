package com.myapp.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import com.myapp.config.JsonPropertyView;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonPropertyView.Basic.class)
    private long id;

    @JsonView(JsonPropertyView.Basic.class)
    private String name;

    @JsonView(JsonPropertyView.Provider.class)
    @ManyToOne
    private Provider provider;

    @JsonView(JsonPropertyView.Customer.class)
    @ManyToMany
    private List<Customer> customerList = new ArrayList<>();

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonView(JsonPropertyView.Category.class)
    private Category category;



    public Product(){

    }

    public Product(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                '}';
    }
}
