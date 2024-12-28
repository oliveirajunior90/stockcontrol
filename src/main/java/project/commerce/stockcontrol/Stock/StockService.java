package project.commerce.stockcontrol.Stock;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import project.commerce.stockcontrol.Product.ProductService;
import project.commerce.stockcontrol.dto.OrderItemDTO;
import project.commerce.stockcontrol.entity.Model.Ingredient;

import java.util.List;

@Service
public class StockService {

    StockRepository stockRepository;
    ProductService productService;

    StockService(StockRepository stockRepository, ProductService productService) {
        this.stockRepository = stockRepository;
        this.productService = productService;
    }

    @Transactional
    public Ingredient save(Ingredient ingredient) {
        return stockRepository.save(ingredient);
    }

    public void updateStockItems(List<OrderItemDTO> orderItemDTO) {

        orderItemDTO.forEach(orderItem -> {

            var productDB = productService.findById(orderItem.productId());
            if(productDB.isPresent()) {
                var ingredientsProduct = productDB.get().getIngredients();

                ingredientsProduct.forEach(item -> {
                    var ingredientStock = stockRepository.findById(item.getIngredientId());
                    if(ingredientStock.isEmpty()) {
                        throw new RuntimeException(String.format("Não há o item de id: %s no estoque", item.getIngredientId()));
                    }

                    var ingredient = new Ingredient();
                    ingredient.setId(item.getIngredientId());
                    ingredient.setUpdatedAt();
                    ingredient.setQuantityInStock(ingredientStock.get().getQuantityInStock() - item.getQuantity() * orderItem.quantity());
                    stockRepository.save(ingredient);
                });
            }

        });
    }
}
