package com.kbtu.gcpfinal.data.repository;

import com.kbtu.gcpfinal.data.entity.SalesReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {
}
