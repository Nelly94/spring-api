package com.myapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.myapp.config.JsonPropertyView;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonPropertyView.Provider.class)
    private long id;

    @JsonView(JsonPropertyView.Provider.class)
    private String companyName;

    @JsonView(JsonPropertyView.Provider.class)
    private String bankAccount;

    @JsonIgnoreProperties("provider")
    @OneToMany(mappedBy = "provider")
    private List<Product> productList = new ArrayList<>();

    public Provider(){

    }

    public Provider(String companyName) {
        this.companyName = companyName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }


    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
