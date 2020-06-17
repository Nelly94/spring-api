package com.myapp.api;

import com.myapp.dao.CategoryRepository;
import com.myapp.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryRestController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("")
    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    @PostMapping("/category")
    public Category add(@RequestBody Category category){
        return categoryRepository.save(category);
    }
}
