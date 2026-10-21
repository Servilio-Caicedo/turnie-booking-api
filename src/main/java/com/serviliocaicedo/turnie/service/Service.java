package com.serviliocaicedo.turnie.service;

import com.serviliocaicedo.turnie.business.Business;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "services")
@Getter
@Setter
@NoArgsConstructor
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 500)
    private String description;

    @Column(name = "reserved_minutes", nullable = false)
    private int reservedMinutes;

    @Column(name = "estimated_minutes")
    private Integer estimatedMinutes;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "business_id", nullable = false)
    private Business business;

    @Column(nullable = false)
    private boolean active = true;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Builder
    public Service(String name, String description, int reservedMinutes, Integer estimatedMinutes, BigDecimal price, Business business) {
        this.name = name;
        this.description = description;
        this.reservedMinutes = reservedMinutes;
        this.estimatedMinutes = estimatedMinutes;
        this.price = price;
        this.business = business;
    }

    @PrePersist
    void onCreate() {
        this.createdAt = Instant.now();
    }
}