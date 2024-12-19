package com.kbtu.gcpfinal.data.mapper;

import com.kbtu.gcpfinal.data.dto.ProductCategoryDTO;
import com.kbtu.gcpfinal.data.entity.ProductCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductCategoryMapper {
    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "category.id", target = "categoryId")
    ProductCategoryDTO productCategoryToProductCategoryDTO(ProductCategory productCategory);

    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "categoryId", target = "category.id")
    ProductCategory productCategoryDTOToProductCategory(ProductCategoryDTO productCategoryDTO);
}
