package project.commerce.stockcontrol.Stock;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.commerce.stockcontrol.dto.OrderItemDTO;
import project.commerce.stockcontrol.entity.Model.Ingredient;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/stock")
public class StockController {

    StockService stockService;

    StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping("/update")
    public ResponseEntity<Boolean> updateStockItems(@RequestBody List<OrderItemDTO> orderItems) {
        try {
            stockService.updateStockItems(orderItems);
            return ResponseEntity.ok(true);
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(false);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Ingredient> createIngredient(@RequestBody Ingredient ingredient) {
        try {
            Ingredient savedIngredient = stockService.save(ingredient);
            return ResponseEntity.ok(savedIngredient);
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(null);
        }
    }

}
