package com.yash.luxevitewishlistservice.dto;

import lombok.*;
import java.time.LocalDateTime;

/**
 * DTO representing a wishlist item response.
 *
 * <p>Returned to clients when fetching wishlist items.</p>
 *
 * author Ishwar G
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WishlistItemResponse {

    /** Primary key ID of the wishlist item. */
    private Long id;

    /** ID of the user who owns the wishlist. */
    private Long userId;

    /** ID of the product in the wishlist. */
    private Long productId;

    /** Timestamp when the product was added to the wishlist. */
    private LocalDateTime addedAt;
}
