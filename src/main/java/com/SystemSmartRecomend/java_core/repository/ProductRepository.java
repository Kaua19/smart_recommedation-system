package com.SystemSmartRecomend.java_core.repository;

import com.SystemSmartRecomend.java_core.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);
}
