package project.commerce.stockcontrol.application.service;

import org.springframework.stereotype.Service;
import project.commerce.stockcontrol.domain.repository.ProductRepository;
import project.commerce.stockcontrol.domain.entity.Product;

import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> findById (Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

}

