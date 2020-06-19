package com.myapp.api;

import com.myapp.dao.ProviderRepository;
import com.myapp.model.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@RequestMapping("/provider")
public class ProviderRestController {

    @Autowired
    private ProviderRepository providerRepository;

    @PostMapping("/add")
    public Provider add(@RequestBody Provider provider){
       return providerRepository.save(provider);
    }
}
