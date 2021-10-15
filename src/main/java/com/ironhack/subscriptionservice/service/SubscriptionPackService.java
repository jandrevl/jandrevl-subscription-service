package com.ironhack.subscriptionservice.service;


import com.ironhack.subscriptionservice.dao.SubscriptionPack;
import com.ironhack.subscriptionservice.dto.SubscriptionPackRequest;
import com.ironhack.subscriptionservice.dto.UserDTO;
import com.ironhack.subscriptionservice.proxy.UserServiceProxy;
import com.ironhack.subscriptionservice.repository.SubscriptionPackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;


@Service
public class SubscriptionPackService {

    @Autowired
    private SubscriptionPackRepository subscriptionPackRepository;
    @Autowired
    private UserServiceProxy userServiceProxy;

    Logger logger = LoggerFactory.getLogger("SubscriptionPackService.Class");



    public SubscriptionPackRequest getActiveUser (Long userId) {

        Optional<SubscriptionPack> optionalPack =
                subscriptionPackRepository.findByUserIdAndSubscriptionPackStartLessThanAndSubscriptionPackEndGreaterThan
                (userId, LocalDate.now(), LocalDate.now());

        SubscriptionPackRequest subscriptionPackRequest = new SubscriptionPackRequest();

        if(optionalPack.isEmpty()) {
            return subscriptionPackRequest;
        }

        subscriptionPackRequest.setUserId(optionalPack.get().getUserId());
        subscriptionPackRequest.setSubscriptionPackStart(optionalPack.get().getSubscriptionPackStart().toString());
        subscriptionPackRequest.setSubscriptionPackEnd(optionalPack.get().getSubscriptionPackEnd().toString());

        subscriptionPackRequest.setPaymentsId(getRandomString());

        return subscriptionPackRequest;


    }

    private String getRandomString() {
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        return generatedString;
    }


    public SubscriptionPack create(SubscriptionPackRequest request) {

        logger.info("getting userId from request");
        Long userId = request.getUserId();


        logger.info("getting an optional user from proxy");
        Optional<UserDTO> optionalUser = Optional.ofNullable(userServiceProxy.getCustomerById(userId));

        logger.info("trying if optionalUser is empty");
        if(optionalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "UserId not valid for subscription");
        }
        System.out.println("Creating new subscriptionPack");
        SubscriptionPack newPack = new SubscriptionPack(userId,
                LocalDate.parse(request.getSubscriptionPackStart()),
                LocalDate.parse(request.getSubscriptionPackEnd()));

        return subscriptionPackRepository.save(newPack);
        
        
    }


}
