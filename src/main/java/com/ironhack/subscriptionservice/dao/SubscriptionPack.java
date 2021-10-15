package com.ironhack.subscriptionservice.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionPack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private LocalDate subscriptionPackStart;
    private LocalDate subscriptionPackEnd;


    public SubscriptionPack(Long userId, LocalDate subscriptionPackStart,
                            LocalDate subscriptionPackEnd) {
        this.userId = userId;
        this.subscriptionPackStart = subscriptionPackStart;
        this.subscriptionPackEnd = subscriptionPackEnd;

    }
}
