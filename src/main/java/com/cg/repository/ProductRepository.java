package com.cg.repository;


import com.cg.model.Product;
import com.cg.model.dto.product.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT NEW com.cg.model.dto.product.ProductDTO (" +
                "pr.id, " +
                "pr.title, " +
                "pr.price, " +
                "pr.unit, " +
                "pr.description, " +
                "pr.category," +
                "pr.avatar" +
            ") " +
            "FROM Product AS pr"
    )
    List<ProductDTO> findAllProductDTO();
}
