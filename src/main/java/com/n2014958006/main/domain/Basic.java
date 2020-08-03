package com.n2014958006.main.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Lombok
@Getter
@Setter
@NoArgsConstructor

// JPA
@Entity
@Table
public class Basic implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String name;

    @Column
    private String label;

    @Column
    private String email;

    @Column
    private String phone;

    @Column(updatable = false)
    private LocalDateTime createdDat;

    @Column
    private LocalDateTime updatedDat;

    @Builder
    public Basic(String name, String label, String email, String phone, LocalDateTime createdDat, LocalDateTime updatedDat) {
        this.name = name;
        this.label = label;
        this.email = email;
        this.phone = phone;
        this.createdDat = createdDat;
        this.updatedDat = updatedDat;
    }
}
