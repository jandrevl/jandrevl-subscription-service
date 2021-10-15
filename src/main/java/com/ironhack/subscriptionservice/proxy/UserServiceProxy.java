package com.ironhack.subscriptionservice.proxy;


import com.ironhack.subscriptionservice.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient("user-service")
@RequestMapping("/api")
public interface UserServiceProxy {

    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    UserDTO getCustomerById(@PathVariable(name = "id") Long id);
}
