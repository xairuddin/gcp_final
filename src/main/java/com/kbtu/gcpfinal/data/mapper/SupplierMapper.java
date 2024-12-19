package com.kbtu.gcpfinal.data.mapper;

import com.kbtu.gcpfinal.data.dto.SupplierDTO;
import com.kbtu.gcpfinal.data.entity.Supplier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    SupplierDTO supplierToSupplierDTO(Supplier supplier);

    Supplier supplierDTOToSupplier(SupplierDTO supplierDTO);
}
