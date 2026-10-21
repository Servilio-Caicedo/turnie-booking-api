package com.serviliocaicedo.turnie.professional;

import com.serviliocaicedo.turnie.service.Service;
import java.util.HashSet;
import java.util.Set;
import com.serviliocaicedo.turnie.business.Business;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Instant;

@Entity
@Table(name = "professionals")
@Getter
@Setter
@NoArgsConstructor
public class Professional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "business_id", nullable = false)
    private Business business;

    @Column(nullable = false)
    private boolean active = true;

    @ManyToMany
    @JoinTable(
    name = "professional_services",
    joinColumns = @JoinColumn(name = "professional_id"),
    inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private Set<Service> services = new HashSet<>();

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @PrePersist
    void onCreate() {
        this.createdAt = Instant.now();
    }

    @Builder
    public Professional(String name, Business business) {
        this.name = name;
        this.business = business;
    }
}
