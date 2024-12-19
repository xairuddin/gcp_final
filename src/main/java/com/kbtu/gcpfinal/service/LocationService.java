package com.kbtu.gcpfinal.service;

import com.kbtu.gcpfinal.data.dto.LocationDTO;
import com.kbtu.gcpfinal.data.entity.Location;
import com.kbtu.gcpfinal.data.mapper.LocationMapper;
import com.kbtu.gcpfinal.data.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    public List<LocationDTO> getAllLocations() {
        return locationRepository.findAll()
                .stream()
                .map(locationMapper::locationToLocationDTO)
                .collect(Collectors.toList());
    }

    public LocationDTO getLocationById(Long id) {
        Optional<Location> location = locationRepository.findById(id);
        return location.map(locationMapper::locationToLocationDTO).orElse(null);
    }

    public LocationDTO createLocation(LocationDTO locationDTO) {
        Location location = locationMapper.locationDTOToLocation(locationDTO);
        Location savedLocation = locationRepository.save(location);
        return locationMapper.locationToLocationDTO(savedLocation);
    }

    public LocationDTO updateLocation(Long id, LocationDTO locationDTO) {
        return locationRepository.findById(id)
                .map(existingLocation -> {
                    existingLocation.setName(locationDTO.getName());
                    existingLocation.setAddress(locationDTO.getAddress());
                    existingLocation.setContactInfo(locationDTO.getContactInfo());
                    existingLocation.setUpdatedAt(locationDTO.getUpdatedAt());
                    Location updatedLocation = locationRepository.save(existingLocation);
                    return locationMapper.locationToLocationDTO(updatedLocation);
                })
                .orElse(null);
    }

    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
