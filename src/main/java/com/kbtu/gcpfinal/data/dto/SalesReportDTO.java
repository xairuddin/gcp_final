package com.kbtu.gcpfinal.data.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesReportDTO {
    private Long id;
    private Long productId;
    private LocalDateTime salesDate;
    private Integer quantitySold;
    private BigDecimal totalRevenue;
}
