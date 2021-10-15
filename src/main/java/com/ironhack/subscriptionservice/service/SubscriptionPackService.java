package com.ironhack.subscriptionservice.service;


import com.ironhack.subscriptionservice.dao.SubscriptionPack;
import com.ironhack.subscriptionservice.dto.SubscriptionPackRequest;
import com.ironhack.subscriptionservice.repository.SubscriptionPackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;


@Service
public class SubscriptionPackService {

    @Autowired
    private SubscriptionPackRepository subscriptionPackRepository;

    public SubscriptionPackRequest getActiveUser (Long userId) {

        Optional<SubscriptionPack> optionalPack =
                subscriptionPackRepository.findByUserIdAndSubscriptionPackStartLessThanAndSubscriptionPackEndGreaterThan
                (userId, LocalDate.now(), LocalDate.now());

        SubscriptionPackRequest subscriptionPackRequest = new SubscriptionPackRequest();

        if(optionalPack.isEmpty()) {
            return subscriptionPackRequest;
        }

        subscriptionPackRequest.setUserId(optionalPack.get().getUserId());
        subscriptionPackRequest.setSubscriptionPackStart(optionalPack.get().getSubscriptionPackStart());
        subscriptionPackRequest.setSubscriptionPackEnd(optionalPack.get().getSubscriptionPackEnd());

        byte[] array = new byte[7];
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        subscriptionPackRequest.setPaymentsId(generatedString);

        return subscriptionPackRequest;


    }
    
    
    public SubscriptionPack create(SubscriptionPackRequest request) {
       
        SubscriptionPack newSubscription = new SubscriptionPack();
        
        Long userId = request.getUserId();
        
        
    }


}
