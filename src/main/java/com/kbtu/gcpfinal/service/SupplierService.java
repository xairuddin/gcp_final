package com.kbtu.gcpfinal.service;

import com.kbtu.gcpfinal.data.dto.SupplierDTO;
import com.kbtu.gcpfinal.data.entity.Supplier;
import com.kbtu.gcpfinal.data.mapper.SupplierMapper;
import com.kbtu.gcpfinal.data.repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class SupplierService {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    public List<SupplierDTO> getAllSuppliers() {
        return supplierRepository.findAll()
                .stream()
                .map(supplierMapper::supplierToSupplierDTO)
                .collect(Collectors.toList());
    }

    public SupplierDTO getSupplierById(Long id) {
        Optional<Supplier> supplier = supplierRepository.findById(id);
        return supplier.map(supplierMapper::supplierToSupplierDTO).orElse(null);
    }

    public SupplierDTO createSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = supplierMapper.supplierDTOToSupplier(supplierDTO);
        Supplier savedSupplier = supplierRepository.save(supplier);
        return supplierMapper.supplierToSupplierDTO(savedSupplier);
    }

    public SupplierDTO updateSupplier(Long id, SupplierDTO supplierDTO) {
        return supplierRepository.findById(id)
                .map(existingSupplier -> {
                    existingSupplier.setName(supplierDTO.getName());
                    existingSupplier.setContactInfo(supplierDTO.getContactInfo());
                    existingSupplier.setUpdatedAt(supplierDTO.getUpdatedAt());
                    Supplier updatedSupplier = supplierRepository.save(existingSupplier);
                    return supplierMapper.supplierToSupplierDTO(updatedSupplier);
                })
                .orElse(null);
    }

    public void deleteSupplier(Long id) {
        supplierRepository.deleteById(id);
    }
}
