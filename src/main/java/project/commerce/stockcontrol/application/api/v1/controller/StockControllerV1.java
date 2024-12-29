package project.commerce.stockcontrol.application.api.v1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.commerce.stockcontrol.application.dto.OrderItemDTO;
import project.commerce.stockcontrol.application.service.StockService;
import project.commerce.stockcontrol.application.usecase.UpdateStockUseCase;
import project.commerce.stockcontrol.domain.entity.Ingredient;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/stock")
public class StockControllerV1 {

    StockService stockService;
    UpdateStockUseCase updateStockUseCase;

    StockControllerV1(StockService stockService, UpdateStockUseCase updateStockUseCase) {
        this.stockService = stockService;
        this.updateStockUseCase = updateStockUseCase;
    }

    @PostMapping("/update-stock")
    public ResponseEntity<Boolean> updateStockItems(@RequestBody List<OrderItemDTO> orderItems) {
        try {
            updateStockUseCase.execute(orderItems);
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
