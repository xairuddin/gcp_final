package com.kbtu.gcpfinal.data.mapper;

import com.kbtu.gcpfinal.data.dto.OrderDTO;
import com.kbtu.gcpfinal.data.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "product.id", target = "productId")
    OrderDTO orderToOrderDTO(Order order);

    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "productId", target = "product.id")
    Order orderDTOToOrder(OrderDTO orderDTO);
}
