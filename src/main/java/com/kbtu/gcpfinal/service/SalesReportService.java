package com.kbtu.gcpfinal.service;

import com.kbtu.gcpfinal.data.dto.SalesReportDTO;
import com.kbtu.gcpfinal.data.entity.SalesReport;
import com.kbtu.gcpfinal.data.mapper.SalesReportMapper;
import com.kbtu.gcpfinal.data.repository.SalesReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class SalesReportService {

    private final SalesReportRepository salesReportRepository;
    private final SalesReportMapper salesReportMapper;

    public List<SalesReportDTO> getAllSalesReports() {
        return salesReportRepository.findAll()
                .stream()
                .map(salesReportMapper::salesReportToSalesReportDTO)
                .collect(Collectors.toList());
    }

    public SalesReportDTO getSalesReportById(Long id) {
        Optional<SalesReport> salesReport = salesReportRepository.findById(id);
        return salesReport.map(salesReportMapper::salesReportToSalesReportDTO).orElse(null);
    }

    public SalesReportDTO createSalesReport(SalesReportDTO salesReportDTO) {
        SalesReport salesReport = salesReportMapper.salesReportDTOToSalesReport(salesReportDTO);
        SalesReport savedSalesReport = salesReportRepository.save(salesReport);
        return salesReportMapper.salesReportToSalesReportDTO(savedSalesReport);
    }

    public void deleteSalesReport(Long id) {
        salesReportRepository.deleteById(id);
    }
}
