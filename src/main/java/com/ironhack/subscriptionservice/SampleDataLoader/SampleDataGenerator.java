package com.ironhack.subscriptionservice.SampleDataLoader;

import com.github.javafaker.Faker;
import com.ironhack.subscriptionservice.dao.SubscriptionPack;
import com.ironhack.subscriptionservice.repository.SubscriptionPackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class SampleDataGenerator implements CommandLineRunner {

    @Autowired
    SubscriptionPackRepository subscriptionPackRepository;

    private final Faker faker;

    public SampleDataGenerator(Faker faker) {

        this.faker = faker;
    }

    @Override
    public void run(String... args) {

        LocalDate startDate;

//        List<SubscriptionPack> sampleSubscriptionPacks = IntStream.rangeClosed(1, 50)
//                .mapToObj(i -> new SubscriptionPack(
//                        faker.number().numberBetween(21, 100),
//                        startDate = getRandomLocalDate(),
//                        convertedStartDate.plusMonths(1)
//                )).collect(Collectors.toList());
//
//        subscriptionPackRepository.saveAll(sampleSubscriptionPacks);

    }

    private LocalDate getRandomLocalDate() {
        Date startDate = faker.date().between(Date.from(Instant.parse("2021-01-01")), Date.from(Instant.parse("2021-08-31")));
        LocalDate convertedStartDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return convertedStartDate;
    }
}
