package com.demo.lovable_clone.service.impl;

import com.demo.lovable_clone.dto.subscription.PlanLimitsResponse;
import com.demo.lovable_clone.dto.subscription.UsageTodayResponse;
import com.demo.lovable_clone.service.UsageService;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {

    @Override
    public UsageTodayResponse getTodayUsageOrRser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitsResponse getCurrentSubscriptionOfUse(Long userId) {
        return null;
    }
}
