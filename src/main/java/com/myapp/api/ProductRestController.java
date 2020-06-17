package com.myapp.api;

import com.myapp.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @GetMapping("")
    public List<Product> getAll(){
        List<Product> myList = Arrays.asList(new Product("Kinder maxi"));
        System.out.println(myList.get(0).toString());
        return myList;
    }
}
