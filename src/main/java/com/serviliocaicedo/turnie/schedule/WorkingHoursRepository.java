package com.serviliocaicedo.turnie.schedule;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WorkingHoursRepository extends JpaRepository<WorkingHours, Long> {
    List<WorkingHours> findByResourceId(Long resourceId);
}