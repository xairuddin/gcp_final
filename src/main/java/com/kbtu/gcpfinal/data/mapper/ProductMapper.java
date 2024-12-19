package com.kbtu.gcpfinal.data.mapper;

import com.kbtu.gcpfinal.data.dto.ProductDTO;
import com.kbtu.gcpfinal.data.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "location.id", target = "locationId")
    ProductDTO productToProductDTO(Product product);

    @Mapping(source = "locationId", target = "location.id")
    Product productDTOToProduct(ProductDTO productDTO);
}
