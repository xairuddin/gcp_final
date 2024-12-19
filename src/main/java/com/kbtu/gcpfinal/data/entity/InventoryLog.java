package com.kbtu.gcpfinal.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "inventory_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "`change`") // Либо используйте "change_amount"
    private Integer change;

    @Column
    private LocalDateTime changeDate;

    @Column
    private String reason;

    @PrePersist
    protected void onCreate() {
        changeDate = LocalDateTime.now();
    }
}
