package com.kbtu.gcpfinal.data.mapper;

import com.kbtu.gcpfinal.data.dto.AlertDTO;
import com.kbtu.gcpfinal.data.entity.Alert;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AlertMapper {
    @Mapping(source = "product.id", target = "productId")
    AlertDTO alertToAlertDTO(Alert alert);

    @Mapping(source = "productId", target = "product.id")
    Alert alertDTOToAlert(AlertDTO alertDTO);
}
