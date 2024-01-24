package com.example.vaccinationcenter.service;

import com.example.vaccinationcenter.entities.CentreVaccination;
import com.example.vaccinationcenter.entities.Citoyen;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CentreService {
     CentreVaccination saveCentre(CentreVaccination centreVaccination);
     List<CentreVaccination> getCentreVaccinations();

}
