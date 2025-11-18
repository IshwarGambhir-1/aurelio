package com.yash.luxevitewishlistservice.service;

import com.yash.luxevitewishlistservice.dto.WishlistItemResponse;
import java.util.List;

/**
 * Service interface for managing wishlist operations.
 *
 * @author Ishwar G
 */
public interface WishlistService {
    WishlistItemResponse addItem(Long userId, Long productId);
    List<WishlistItemResponse> getItemsForUser(Long userId);
    void removeItem(Long userId, Long productId);
    long clearWishlist(Long userId);
}
