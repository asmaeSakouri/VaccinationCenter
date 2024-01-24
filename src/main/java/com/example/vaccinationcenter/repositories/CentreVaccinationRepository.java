package com.example.vaccinationcenter.repositories;

import com.example.vaccinationcenter.entities.CentreVaccination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CentreVaccinationRepository extends JpaRepository<CentreVaccination,Long> {

}
