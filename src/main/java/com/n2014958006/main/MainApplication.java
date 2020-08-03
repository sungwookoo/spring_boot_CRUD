package com.n2014958006.main;

import com.n2014958006.main.domain.Basic;
import com.n2014958006.main.domain.Profile;
import com.n2014958006.main.repository.BasicRepository;
import com.n2014958006.main.repository.ProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner(BasicRepository basicRepository) {
        return (args) -> {
            basicRepository.save(Basic.builder()
                    .name("홍길동")
                    .label("CEO")
                    .email("hong@gmail.com")
                    .phone("012-123-4567")
                    .createdDat(LocalDateTime.now())
                    .build());
            basicRepository.save(Basic.builder()
                    .name("장길산")
                    .label("CFO")
                    .email("jang@gmail.com")
                    .phone("123-456-7890")
                    .createdDat(LocalDateTime.now())
                    .build());
            basicRepository.save(Basic.builder()
                    .name("춘향이")
                    .label("CTO")
                    .email("chun@gmail.com")
                    .phone("234-567-8901")
                    .createdDat(LocalDateTime.now())
                    .build());
        };
    }

    @Bean
    public CommandLineRunner runner2(ProfileRepository profileRepository) {
        return (args) -> {
            profileRepository.save(Profile.builder()
                    .network("트위터")
                    .username("@home")
                    .url("https://www.twitter.com/@home")
                    .createdDat(LocalDateTime.now())
                    .build());
            profileRepository.save(Profile.builder()
                    .network("페이스북")
                    .username("@home")
                    .url("https://www.facebook.com/@home")
                    .createdDat(LocalDateTime.now())
                    .build());
            profileRepository.save(Profile.builder()
                    .network("인스타그램")
                    .username("@home")
                    .url("https://www.instagram.com/@home")
                    .createdDat(LocalDateTime.now())
                    .build());
        };
    }

}
