package com.serviliocaicedo.turnie.professional;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
    List<Professional> findByBusinessId(Long businessId);
}