package com.wvcneto.springworkshop.services;

import com.wvcneto.springworkshop.entities.Product;
import com.wvcneto.springworkshop.repositories.ProductRepository;
import com.wvcneto.springworkshop.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() { return productRepository.findAll(); }

    public Product findById(Long id) {
        Optional<Product> product = productRepository.findById(id);

        return product.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
