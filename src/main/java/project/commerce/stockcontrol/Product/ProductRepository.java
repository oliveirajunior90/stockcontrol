package project.commerce.stockcontrol.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import project.commerce.stockcontrol.entity.Model.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> getProductsByIdIn(List<Long> productIds);

}
