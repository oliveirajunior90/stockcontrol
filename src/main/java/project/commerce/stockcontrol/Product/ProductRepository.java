package project.commerce.stockcontrol.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import project.commerce.stockcontrol.entity.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
