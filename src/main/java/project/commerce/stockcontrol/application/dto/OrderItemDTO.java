package project.commerce.stockcontrol.application.dto;

public record OrderItemDTO(
        Long orderId,
        Long productId,
        int quantity
) {
}
