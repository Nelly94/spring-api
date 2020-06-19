package com.myapp.api;

import com.fasterxml.jackson.annotation.JsonView;
import com.myapp.config.JsonPropertyView;
import com.myapp.dao.ProductRepository;
import com.myapp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/basic")
    @JsonView(JsonPropertyView.Basic.class)
    public List<Product> getAllBasic(){
        return productRepository.findAll();
    }

    @GetMapping("/category")
    @JsonView(JsonPropertyView.Category.class)
    public List<Product> getAllWithCategory(){
        return productRepository.findAll();
    }

    @GetMapping("/provider")
    @JsonView(JsonPropertyView.Provider.class)
    public List<Product> getAllWithProvider(){
        return productRepository.findAll();
    }

    @GetMapping("")
    @JsonView(JsonPropertyView.Basic.class)
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    @PostMapping("/product")
    public Product add(@RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping("/product/{id}")
    public void edit(@RequestBody Product product, @PathVariable int id) throws ResponseStatusException{
        Product p = productRepository.getOne((long) id);
        if(p==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }else{
            p.setId(id);
            productRepository.save(p);
        }
    }

    @PatchMapping("/{id}")
    public Product partialEdit(@RequestBody Map<String, Object> fields, @PathVariable int id){
        Product p = productRepository.findById((long) id).get();

        fields.forEach((key, value) -> {
            Field field = ReflectionUtils.findField(Product.class, key);
            ReflectionUtils.makeAccessible(field);
            ReflectionUtils.setField(field, p, value);
        });

        productRepository.save(p);
        return p;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) throws ResponseStatusException{
        try {
            Product p = productRepository.findById((long) id).get();
            if (p == null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
            } else {
                productRepository.delete(p);
            }
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }
}
