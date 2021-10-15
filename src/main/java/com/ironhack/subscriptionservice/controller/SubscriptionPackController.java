package com.ironhack.subscriptionservice.controller;

import com.ironhack.subscriptionservice.dao.SubscriptionPack;
import com.ironhack.subscriptionservice.dto.SubscriptionPackRequest;
import com.ironhack.subscriptionservice.dto.UserDTO;
import com.ironhack.subscriptionservice.proxy.UserServiceProxy;
import com.ironhack.subscriptionservice.service.SubscriptionPackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SubscriptionPackController {

    @Autowired
    private SubscriptionPackService subscriptionPackService;
    @Autowired
    private UserServiceProxy userServiceProxy;

    @GetMapping("/subscriptions/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public SubscriptionPackRequest getSubscriptionPack(@PathVariable(name = "userId") Long userId) {

        return subscriptionPackService.getActiveUser(userId);

    }

    @GetMapping("/usercustomer/{id}")
    public UserDTO getUserCustomer(@PathVariable(name = "id") Long id) {

        return userServiceProxy.getCustomerById(id);
    }




    @PostMapping("/subscriptions")
    @ResponseStatus(HttpStatus.CREATED)
    public SubscriptionPack createSubscription(@RequestBody SubscriptionPackRequest request) {
        
        return subscriptionPackService.create(request);
        
        
    }


}
