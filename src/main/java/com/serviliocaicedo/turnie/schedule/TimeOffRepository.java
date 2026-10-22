package com.serviliocaicedo.turnie.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TimeOffRepository  extends JpaRepository<TimeOff, Long> {
    List<TimeOff> findByResourceId(Long resourceId);
}