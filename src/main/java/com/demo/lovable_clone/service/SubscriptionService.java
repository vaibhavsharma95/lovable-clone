package com.demo.lovable_clone.service;

import com.demo.lovable_clone.dto.subscription.CheckoutRequest;
import com.demo.lovable_clone.dto.subscription.CheckoutResponse;
import com.demo.lovable_clone.dto.subscription.PortalResponse;
import com.demo.lovable_clone.dto.subscription.SubscriptionResponse;

public interface SubscriptionService {
    SubscriptionResponse getCurrentSubscription();

    CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request, Long userId);

    PortalResponse openCustomerPortal(CheckoutRequest request, Long userId);
}
