package com.yash.luxevitewishlistservice.controller;

import com.yash.luxevitewishlistservice.dto.AddItemRequest;
import com.yash.luxevitewishlistservice.dto.WishlistItemResponse;
import com.yash.luxevitewishlistservice.service.WishlistService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller exposing wishlist endpoints.
 *
 * @author Ishwar G
 */
@RestController
@RequestMapping("/api/v1/wishlist")
@RequiredArgsConstructor
public class WishlistController {

    private final WishlistService wishlistService;

    @PostMapping("/items")
    public ResponseEntity<WishlistItemResponse> addItem(@Valid @RequestBody AddItemRequest req) {
        return ResponseEntity.ok(wishlistService.addItem(req.getUserId(), req.getProductId()));
    }

    @GetMapping("/users/{userId}/items")
    public ResponseEntity<List<WishlistItemResponse>> getItems(@PathVariable Long userId) {
        return ResponseEntity.ok(wishlistService.getItemsForUser(userId));
    }

    @DeleteMapping("/users/{userId}/items/{productId}")
    public ResponseEntity<Void> removeItem(@PathVariable Long userId, @PathVariable Long productId) {
        wishlistService.removeItem(userId, productId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Long> clearWishlist(@PathVariable Long userId) {
        return ResponseEntity.ok(wishlistService.clearWishlist(userId));
    }
}
