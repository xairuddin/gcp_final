package com.kbtu.gcpfinal.service;

import com.kbtu.gcpfinal.data.dto.InventoryLogDTO;
import com.kbtu.gcpfinal.data.entity.InventoryLog;
import com.kbtu.gcpfinal.data.mapper.InventoryLogMapper;
import com.kbtu.gcpfinal.data.repository.InventoryLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class InventoryLogService {

    private final InventoryLogRepository inventoryLogRepository;
    private final InventoryLogMapper inventoryLogMapper;

    public List<InventoryLogDTO> getAllInventoryLogs() {
        return inventoryLogRepository.findAll()
                .stream()
                .map(inventoryLogMapper::inventoryLogToInventoryLogDTO)
                .collect(Collectors.toList());
    }

    public InventoryLogDTO getInventoryLogById(Long id) {
        Optional<InventoryLog> inventoryLog = inventoryLogRepository.findById(id);
        return inventoryLog.map(inventoryLogMapper::inventoryLogToInventoryLogDTO).orElse(null);
    }

    public InventoryLogDTO createInventoryLog(InventoryLogDTO inventoryLogDTO) {
        InventoryLog inventoryLog = inventoryLogMapper.inventoryLogDTOToInventoryLog(inventoryLogDTO);
        InventoryLog savedInventoryLog = inventoryLogRepository.save(inventoryLog);
        return inventoryLogMapper.inventoryLogToInventoryLogDTO(savedInventoryLog);
    }

    public InventoryLogDTO updateInventoryLog(Long id, InventoryLogDTO inventoryLogDTO) {
        return inventoryLogRepository.findById(id)
                .map(existingInventoryLog -> {
                    existingInventoryLog.setChange(inventoryLogDTO.getChange());
                    existingInventoryLog.setChangeDate(inventoryLogDTO.getChangeDate());
                    existingInventoryLog.setReason(inventoryLogDTO.getReason());
                    InventoryLog updatedInventoryLog = inventoryLogRepository.save(existingInventoryLog);
                    return inventoryLogMapper.inventoryLogToInventoryLogDTO(updatedInventoryLog);
                })
                .orElse(null);
    }

    public void deleteInventoryLog(Long id) {
        inventoryLogRepository.deleteById(id);
    }
}
