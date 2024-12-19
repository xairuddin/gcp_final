package com.kbtu.gcpfinal.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "sales_reports")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private LocalDateTime salesDate;

    @Column(nullable = false)
    private Integer quantitySold;

    @Column(nullable = false)
    private BigDecimal totalRevenue;

    @PrePersist
    protected void onCreate() {
        salesDate = LocalDateTime.now();
    }
}
