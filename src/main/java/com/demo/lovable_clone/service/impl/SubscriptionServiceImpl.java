package com.demo.lovable_clone.service.impl;

import com.demo.lovable_clone.dto.subscription.CheckoutRequest;
import com.demo.lovable_clone.dto.subscription.CheckoutResponse;
import com.demo.lovable_clone.dto.subscription.PortalResponse;
import com.demo.lovable_clone.dto.subscription.SubscriptionResponse;
import com.demo.lovable_clone.service.SubscriptionService;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    @Override
    public SubscriptionResponse getCurrentSubscription() {
        return null;
    }

    @Override
    public CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId) {
        return null;
    }

    @Override
    public PortalResponse openCustomerPortal(CheckoutRequest request, Long userId) {
        return null;
    }
}
