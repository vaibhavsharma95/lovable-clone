package com.demo.lovable_clone.dto.subscription;

public record PlanLimitsResponse(
        String planName,
        Integer maxTokensPerDev,
        Integer maxPorjects,
        boolean unlimitedMetaAi
        ) {
}
