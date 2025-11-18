package com.yash.luxevitewishlistservice.serviceimpl;

import com.yash.luxevitewishlistservice.dto.WishlistItemResponse;
import com.yash.luxevitewishlistservice.model.WishlistItem;
import com.yash.luxevitewishlistservice.exception.ResourceNotFoundException;
import com.yash.luxevitewishlistservice.repository.WishlistItemRepository;
import com.yash.luxevitewishlistservice.service.WishlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Implementation of {@link WishlistService}.
 *
 * @author Ishwar G
 */
@Service
@RequiredArgsConstructor
public class WishlistServiceImpl implements WishlistService {

    private final WishlistItemRepository repository;

    @Override
    @Transactional
    public WishlistItemResponse addItem(Long userId, Long productId) {
        repository.findByUserIdAndProductId(userId, productId)
                  .ifPresent(i -> { throw new IllegalArgumentException("Product already in wishlist"); });

        WishlistItem saved = repository.save(
                WishlistItem.builder()
                        .userId(userId)
                        .productId(productId)
                        .build()
        );

        return WishlistItemResponse.builder()
                .id(saved.getId())
                .userId(saved.getUserId())
                .productId(saved.getProductId())
                .addedAt(saved.getAddedAt())
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public List<WishlistItemResponse> getItemsForUser(Long userId) {
        return repository.findByUserIdOrderByAddedAtDesc(userId).stream()
                .map(i -> WishlistItemResponse.builder()
                        .id(i.getId())
                        .userId(i.getUserId())
                        .productId(i.getProductId())
                        .addedAt(i.getAddedAt())
                        .build())
                .toList();
    }

    @Override
    @Transactional
    public void removeItem(Long userId, Long productId) {
        long deleted = repository.deleteByUserIdAndProductId(userId, productId);
        if (deleted == 0) {
            throw new ResourceNotFoundException("Wishlist item not found for userId=" + userId + " productId=" + productId);
        }
    }

    @Override
    @Transactional
    public long clearWishlist(Long userId) {
        return repository.deleteByUserId(userId);
    }
}
