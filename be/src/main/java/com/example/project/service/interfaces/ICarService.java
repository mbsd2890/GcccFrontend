package com.example.project.service.interfaces;

import com.example.project.domain.dto.CarDTO;

import java.util.List;

public interface ICarService {
    List<CarDTO> findAll();
    void save(CarDTO carDTO);
    void deleteCar(Long id);
    CarDTO getCarById(Long id);
    CarDTO updateCar(CarDTO carDTO);
}
