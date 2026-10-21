package com.serviliocaicedo.turnie.business;

import com.serviliocaicedo.turnie.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BusinessRepository extends JpaRepository<Business, Long> {
    List<Business> findByOwnerId(Long ownerId);
    List<Business> findByNameContainingIgnoreCase(String name);
}