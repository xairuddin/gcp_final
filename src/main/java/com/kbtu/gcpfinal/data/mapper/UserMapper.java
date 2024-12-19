package com.kbtu.gcpfinal.data.mapper;

import com.kbtu.gcpfinal.data.dto.UserDTO;
import com.kbtu.gcpfinal.data.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "passwordHash", ignore = true)
    UserDTO userToUserDTO(User user);

    User userDTOToUser(UserDTO userDTO);
}
