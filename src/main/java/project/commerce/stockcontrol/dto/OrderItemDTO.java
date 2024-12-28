package project.commerce.stockcontrol.dto;

public record OrderItemDTO(
        Long orderId,
        Long productId,
        int quantity
) {
}
