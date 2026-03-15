package com.demo.lovable_clone.dto.subscription;

public record UsageTodayResponse(
        Integer tokenUsed,
        Integer tokenList,
        Integer previewRunning,
        Integer previewLimit
) {
}
