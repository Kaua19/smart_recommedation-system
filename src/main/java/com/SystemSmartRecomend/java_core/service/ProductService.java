package com.SystemSmartRecomend.java_core.service;

import com.SystemSmartRecomend.java_core.entity.Product;
import com.SystemSmartRecomend.java_core.repository.ProductRepository;
import com.SystemSmartRecomend.java_core.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository){
        this.repository = repository;
    }

    public Product create(Product product){
        return repository.save(product);
    }

    public List<Product> getAll(){
        return repository.findAll();
    }

    public Optional<Product> getById(Long id){
        return repository.findById(id);
    }

    public List<Product> getByCategory(String category){
        return repository.findByCategory(category);
    }

    public Product update(Long id, Product updated){
        return repository.findById(id)
                .map(product -> {
                    product.setName(updated.getName());
                    product.setCategory(updated.getCategory());
                    product.setPrice(updated.getPrice());
                    product.setDescription(updated.getDescription());
                    product.setImageUrl(updated.getImageUrl());
                    return repository.save(product);
                })
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
