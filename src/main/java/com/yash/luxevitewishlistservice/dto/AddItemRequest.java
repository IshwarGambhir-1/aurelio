package com.yash.luxevitewishlistservice.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * DTO for adding a product to a user's wishlist.
 *
 * <p>Contains userId and productId fields.</p>
 *
 * author Ishwar G
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddItemRequest {

    /** ID of the user. */
    @NotNull(message = "userId is required")
    private Long userId;

    /** ID of the product. */
    @NotNull(message = "productId is required")
    private Long productId;
}
