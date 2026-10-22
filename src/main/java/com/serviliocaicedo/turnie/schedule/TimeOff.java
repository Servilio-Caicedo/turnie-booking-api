package com.serviliocaicedo.turnie.schedule;

import com.serviliocaicedo.turnie.resource.Resource;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.Instant;

@Entity
@Table(name = "time_off")
@Getter
@Setter
@NoArgsConstructor
public class TimeOff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "resource_id", nullable = false)
    private Resource resource;

    @Column(name = "start_at", nullable = false)
    private Instant startAt;

    @Column(name = "end_at", nullable = false)
    private Instant endAt;

    @Column(length = 255)
    private String reason;

    @Builder
    public TimeOff(Resource resource, Instant startAt, Instant endAt, String reason) {
        this.resource = resource;
        this.startAt = startAt;
        this.endAt = endAt;
        this.reason = reason;
    }
}