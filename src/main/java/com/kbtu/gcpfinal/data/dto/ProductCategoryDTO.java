package com.kbtu.gcpfinal.data.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCategoryDTO {
    private Long id;
    private Long productId;
    private Long categoryId;
}
