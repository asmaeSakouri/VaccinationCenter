package com.example.vaccinationcenter.service;

import com.example.vaccinationcenter.entities.Citoyen;
import com.example.vaccinationcenter.repositories.CitoyenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class CitoyenServiceImpl implements CitoyenService {
    private CitoyenRepository citoyenRepository;
    @Override
    public Citoyen saveCitoyen(Citoyen citoyen) {
        return citoyenRepository.save(citoyen);
    }
    @Override
    public List<Citoyen> getCitoyens() {
        return citoyenRepository.findAll();
    }
}
