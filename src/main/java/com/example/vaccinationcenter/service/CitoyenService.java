package com.example.vaccinationcenter.service;

import com.example.vaccinationcenter.entities.Citoyen;

import java.util.List;

public interface CitoyenService {
    Citoyen saveCitoyen(Citoyen citoyen);
    List<Citoyen> getCitoyens();

}
