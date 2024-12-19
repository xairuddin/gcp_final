package com.kbtu.gcpfinal.controller;

import com.kbtu.gcpfinal.data.dto.SalesReportDTO;
import com.kbtu.gcpfinal.service.SalesReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales-reports")
@RequiredArgsConstructor
public class SalesReportController {

    private final SalesReportService salesReportService;

    @GetMapping
    public ResponseEntity<List<SalesReportDTO>> getAllSalesReports() {
        return ResponseEntity.ok(salesReportService.getAllSalesReports());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesReportDTO> getSalesReportById(@PathVariable Long id) {
        SalesReportDTO salesReportDTO = salesReportService.getSalesReportById(id);
        if (salesReportDTO != null) {
            return ResponseEntity.ok(salesReportDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<SalesReportDTO> createSalesReport(@RequestBody SalesReportDTO salesReportDTO) {
        return ResponseEntity.ok(salesReportService.createSalesReport(salesReportDTO));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalesReport(@PathVariable Long id) {
        salesReportService.deleteSalesReport(id);
        return ResponseEntity.noContent().build();
    }
}
