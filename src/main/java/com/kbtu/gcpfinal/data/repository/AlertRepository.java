package com.kbtu.gcpfinal.data.repository;

import com.kbtu.gcpfinal.data.entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long> {
}
