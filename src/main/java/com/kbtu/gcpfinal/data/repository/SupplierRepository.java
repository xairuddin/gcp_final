package com.kbtu.gcpfinal.data.repository;

import com.kbtu.gcpfinal.data.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
