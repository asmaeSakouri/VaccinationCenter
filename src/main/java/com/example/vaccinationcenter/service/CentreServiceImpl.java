package com.example.vaccinationcenter.service;

import com.example.vaccinationcenter.entities.CentreVaccination;
import com.example.vaccinationcenter.entities.Citoyen;
import com.example.vaccinationcenter.repositories.CentreVaccinationRepository;
import com.example.vaccinationcenter.repositories.CitoyenRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CentreServiceImpl implements CentreService {
    CentreVaccinationRepository centreVaccinationRepository;
    @Override
    public CentreVaccination saveCentre(CentreVaccination centreVaccination) {
        return centreVaccinationRepository.save(centreVaccination);
    }
    @Override
    public List<CentreVaccination> getCentreVaccinations() {
        return centreVaccinationRepository.findAll();
    }
}
