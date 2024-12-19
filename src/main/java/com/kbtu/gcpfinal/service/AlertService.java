package com.kbtu.gcpfinal.service;

import com.kbtu.gcpfinal.data.dto.AlertDTO;
import com.kbtu.gcpfinal.data.entity.Alert;
import com.kbtu.gcpfinal.data.mapper.AlertMapper;
import com.kbtu.gcpfinal.data.repository.AlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class AlertService {

    private final AlertRepository alertRepository;
    private final AlertMapper alertMapper;
    public List<AlertDTO> getAllAlerts() {
        return alertRepository.findAll()
                .stream()
                .map(alertMapper::alertToAlertDTO)
                .collect(Collectors.toList());
    }

    public AlertDTO getAlertById(Long id) {
        Optional<Alert> alert = alertRepository.findById(id);
        return alert.map(alertMapper::alertToAlertDTO).orElse(null);
    }

    public AlertDTO createAlert(AlertDTO alertDTO) {
        Alert alert = alertMapper.alertDTOToAlert(alertDTO);
        Alert savedAlert = alertRepository.save(alert);
        return alertMapper.alertToAlertDTO(savedAlert);
    }

    public AlertDTO updateAlert(Long id, AlertDTO alertDTO) {
        return alertRepository.findById(id)
                .map(existingAlert -> {
                    existingAlert.setAlertType(alertDTO.getAlertType());
                    existingAlert.setMessage(alertDTO.getMessage());
                    existingAlert.setSentAt(alertDTO.getSentAt());
                    Alert updatedAlert = alertRepository.save(existingAlert);
                    return alertMapper.alertToAlertDTO(updatedAlert);
                })
                .orElse(null);
    }

    public void deleteAlert(Long id) {
        alertRepository.deleteById(id);
    }
}
