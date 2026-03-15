package com.demo.lovable_clone.dto.subscription;

import java.time.Instant;

public record SubscriptionResponse (
        PlanResponse planResponse,
        String status,
        Instant periodEnd,
        Long tokenUsedThisCycle
) {
}
