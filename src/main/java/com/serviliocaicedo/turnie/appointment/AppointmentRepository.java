package com.serviliocaicedo.turnie.appointment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    List<Appointment> findByClientId(Long clientId);
    List<Appointment> findByServiceId(Long serviceId);
    List<Appointment> findByResourceId(Long resourceId);
}