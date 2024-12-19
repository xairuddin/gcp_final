package com.kbtu.gcpfinal.data.mapper;

import com.kbtu.gcpfinal.data.dto.InventoryLogDTO;
import com.kbtu.gcpfinal.data.entity.InventoryLog;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InventoryLogMapper {
    @Mapping(source = "product.id", target = "productId")
    InventoryLogDTO inventoryLogToInventoryLogDTO(InventoryLog inventoryLog);

    @Mapping(source = "productId", target = "product.id")
    InventoryLog inventoryLogDTOToInventoryLog(InventoryLogDTO inventoryLogDTO);
}
