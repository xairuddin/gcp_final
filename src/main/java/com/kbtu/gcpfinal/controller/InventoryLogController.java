package com.kbtu.gcpfinal.controller;

import com.kbtu.gcpfinal.data.dto.InventoryLogDTO;
import com.kbtu.gcpfinal.service.InventoryLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory-logs")
@RequiredArgsConstructor
public class InventoryLogController {

    private final InventoryLogService inventoryLogService;

    @GetMapping
    public ResponseEntity<List<InventoryLogDTO>> getAllInventoryLogs() {
        return ResponseEntity.ok(inventoryLogService.getAllInventoryLogs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryLogDTO> getInventoryLogById(@PathVariable Long id) {
        InventoryLogDTO inventoryLogDTO = inventoryLogService.getInventoryLogById(id);
        if (inventoryLogDTO != null) {
            return ResponseEntity.ok(inventoryLogDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<InventoryLogDTO> createInventoryLog(@RequestBody InventoryLogDTO inventoryLogDTO) {
        return ResponseEntity.ok(inventoryLogService.createInventoryLog(inventoryLogDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryLogDTO> updateInventoryLog(@PathVariable Long id, @RequestBody InventoryLogDTO inventoryLogDTO) {
        InventoryLogDTO updatedInventoryLog = inventoryLogService.updateInventoryLog(id, inventoryLogDTO);
        if (updatedInventoryLog != null) {
            return ResponseEntity.ok(updatedInventoryLog);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventoryLog(@PathVariable Long id) {
        inventoryLogService.deleteInventoryLog(id);
        return ResponseEntity.noContent().build();
    }
}
