package com.kbtu.gcpfinal.data.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Integer quantity;
    private BigDecimal price;
    private Long locationId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
