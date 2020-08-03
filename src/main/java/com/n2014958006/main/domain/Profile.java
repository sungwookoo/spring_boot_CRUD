package com.n2014958006.main.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.sun.xml.internal.ws.developer.UsesJAXBContext;
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
public class Profile implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String network;

    @Column
    private String username;

    @Column
    private String url;

    @Column(updatable = false)
    private LocalDateTime createdDat;

    @Column
    private LocalDateTime updatedDat;

    @Builder
    public Profile(String network, String username, String url, LocalDateTime createdDat, LocalDateTime updatedDat) {
        this.network = network;
        this.username = username;
        this.url = url;
        this.createdDat = createdDat;
        this.updatedDat = updatedDat;
    }
}
