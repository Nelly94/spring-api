package com.myapp.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.myapp.config.JsonPropertyView;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonPropertyView.Category.class)
    private long id;

    @JsonView(JsonPropertyView.Category.class)
    private String type;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category(){

    }

    public Category(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
