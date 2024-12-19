package com.kbtu.gcpfinal.data.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryLogDTO {
    private Long id;
    private Long productId;
    private Integer change;
    private LocalDateTime changeDate;
    private String reason;
}
