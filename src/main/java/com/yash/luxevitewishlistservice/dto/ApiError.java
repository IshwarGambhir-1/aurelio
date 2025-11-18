package com.yash.luxevitewishlistservice.dto;

import lombok.*;
import java.time.Instant;

/**
 * DTO representing an API error response.
 *
 * <p>Contains status, error, message, and path details.</p>
 *
 * author Ishwar G
 */
@Getter
@Setter
@AllArgsConstructor
@Builder
public class ApiError {

    /** Time when the error response was generated. */
    @Builder.Default
    private Instant timestamp = Instant.now();

    /** HTTP status code. */
    private int status;

    /** Standard error description. */
    private String error;

    /** Human-friendly message. */
    private String message;

    /** Request path that caused the error. */
    private String path;
}
