package project.commerce.stockcontrol.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.commerce.stockcontrol.domain.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
