package com.kbtu.gcpfinal.data.mapper;

import com.kbtu.gcpfinal.data.dto.LocationDTO;
import com.kbtu.gcpfinal.data.entity.Location;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationDTO locationToLocationDTO(Location location);

    Location locationDTOToLocation(LocationDTO locationDTO);
}
