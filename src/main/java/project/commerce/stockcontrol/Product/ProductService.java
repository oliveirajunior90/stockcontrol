package project.commerce.stockcontrol.Product;

import project.commerce.stockcontrol.entity.Model.Product;

import java.util.List;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductsByIdIn(List<Long> productIds) {
        return productRepository.getProductsByIdIn(productIds);
    }
}

