package com.yash.luxevitewishlistservice.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

/**
 * Entity representing a wishlist item.
 *
 * <p>Each item links a user to a product they have added to their wishlist.</p>
 *
 * author Ishwar G
 */
@Entity
@Table(
    name = "wishlist_items",
    uniqueConstraints = @UniqueConstraint(name = "uq_user_product", columnNames = {"user_id", "product_id"})
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(of = {"userId", "productId"})
public class WishlistItem {

    /** Primary key ID. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** ID of the user who owns the wishlist. */
    @Column(name = "user_id", nullable = false)
    private Long userId;

    /** ID of the product added to the wishlist. */
    @Column(name = "product_id", nullable = false)
    private Long productId;

    /** Timestamp when the product was added. */
    @Column(name = "added_at", nullable = false)
    @Builder.Default
    private LocalDateTime addedAt = LocalDateTime.now();
}
