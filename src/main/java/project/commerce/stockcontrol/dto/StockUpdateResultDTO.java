package project.commerce.stockcontrol.dto;

import java.util.Map;

public record StockUpdateResultDTO(Map<Long, String> notInStock, Map<Long, String> productNotAvailable) {
}
