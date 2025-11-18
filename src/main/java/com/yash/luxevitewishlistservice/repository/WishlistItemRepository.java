package com.yash.luxevitewishlistservice.repository;

import com.yash.luxevitewishlistservice.model.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for wishlist items.
 *
 * <p>Provides CRUD operations and custom queries for wishlist items.</p>
 *
 * author Ishwar G
 */
public interface WishlistItemRepository extends JpaRepository<WishlistItem, Long> {

    /**
     * Finds all wishlist items for a user ordered by most recent.
     *
     * @param userId the user ID
     * @return list of wishlist items
     */
    List<WishlistItem> findByUserIdOrderByAddedAtDesc(Long userId);

    /**
     * Finds a wishlist item for a user-product combination.
     *
     * @param userId    the user ID
     * @param productId the product ID
     * @return optional wishlist item
     */
    Optional<WishlistItem> findByUserIdAndProductId(Long userId, Long productId);

    /**
     * Deletes a wishlist item by user and product.
     *
     * @param userId    the user ID
     * @param productId the product ID
     * @return number of rows deleted
     */
    long deleteByUserIdAndProductId(Long userId, Long productId);

    /**
     * Deletes all wishlist items for a user.
     *
     * @param userId the user ID
     * @return number of rows deleted
     */
    long deleteByUserId(Long userId);
}
