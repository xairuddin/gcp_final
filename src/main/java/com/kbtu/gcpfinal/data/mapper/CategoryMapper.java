package com.kbtu.gcpfinal.data.mapper;

import com.kbtu.gcpfinal.data.dto.CategoryDTO;
import com.kbtu.gcpfinal.data.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO categoryToCategoryDTO(Category category);

    Category categoryDTOToCategory(CategoryDTO categoryDTO);
}
