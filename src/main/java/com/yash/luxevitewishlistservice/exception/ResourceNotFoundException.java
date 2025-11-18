package com.yash.luxevitewishlistservice.exception;

import lombok.experimental.StandardException;

/**
 * Exception thrown when a requested resource is not found.
 *
 * <p>Used for missing wishlist items.</p>
 *
 * author Ishwar G
 */
@StandardException
public class ResourceNotFoundException extends RuntimeException {}
