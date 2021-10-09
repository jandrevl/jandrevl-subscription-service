package com.ironhack.subscriptionservice.repository;

import com.ironhack.subscriptionservice.dao.SubscriptionPack;
import com.ironhack.subscriptionservice.repository.SubscriptionPackRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface SubscriptionPackRepository extends JpaRepository<SubscriptionPack, Long> {

    Optional<SubscriptionPack> findByUserIdAndSubscriptionPackStartLessThanAndSubscriptionPackEndGreaterThan
            (Long userId, LocalDate today1, LocalDate today2);
}
