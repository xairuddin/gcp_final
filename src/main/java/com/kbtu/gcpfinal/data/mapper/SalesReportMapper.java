package com.kbtu.gcpfinal.data.mapper;

import com.kbtu.gcpfinal.data.dto.SalesReportDTO;
import com.kbtu.gcpfinal.data.entity.SalesReport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SalesReportMapper {

    @Mapping(source = "product.id", target = "productId")
    SalesReportDTO salesReportToSalesReportDTO(SalesReport salesReport);

    @Mapping(source = "productId", target = "product.id")
    SalesReport salesReportDTOToSalesReport(SalesReportDTO salesReportDTO);
}
