package com.demo.lovable_clone.service;

import com.demo.lovable_clone.dto.subscription.PlanLimitsResponse;
import com.demo.lovable_clone.dto.subscription.UsageTodayResponse;

public interface UsageService {
    UsageTodayResponse getTodayUsageOrRser(Long userId);

    PlanLimitsResponse getCurrentSubscriptionOfUse(Long userId);
}
