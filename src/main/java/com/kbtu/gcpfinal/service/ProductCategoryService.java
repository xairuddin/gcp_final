package com.kbtu.gcpfinal.service;

import com.kbtu.gcpfinal.data.dto.ProductCategoryDTO;
import com.kbtu.gcpfinal.data.entity.ProductCategory;
import com.kbtu.gcpfinal.data.mapper.ProductCategoryMapper;
import com.kbtu.gcpfinal.data.repository.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;
    private final ProductCategoryMapper productCategoryMapper;

    public List<ProductCategoryDTO> getAllProductCategories() {
        return productCategoryRepository.findAll()
                .stream()
                .map(productCategoryMapper::productCategoryToProductCategoryDTO)
                .collect(Collectors.toList());
    }

    public ProductCategoryDTO getProductCategoryById(Long id) {
        Optional<ProductCategory> productCategory = productCategoryRepository.findById(id);
        return productCategory.map(productCategoryMapper::productCategoryToProductCategoryDTO).orElse(null);
    }

    public ProductCategoryDTO createProductCategory(ProductCategoryDTO productCategoryDTO) {
        ProductCategory productCategory = productCategoryMapper.productCategoryDTOToProductCategory(productCategoryDTO);
        ProductCategory savedProductCategory = productCategoryRepository.save(productCategory);
        return productCategoryMapper.productCategoryToProductCategoryDTO(savedProductCategory);
    }

    public void deleteProductCategory(Long id) {
        productCategoryRepository.deleteById(id);
    }
}
