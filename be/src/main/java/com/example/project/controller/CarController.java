package com.example.project.controller;

import com.example.project.domain.dto.CarDTO;
import com.example.project.service.interfaces.ICarService;
import jakarta.annotation.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CarController {

    @Resource
    private final ICarService carService;

    public CarController(ICarService service) {this.carService =  service; }

    @GetMapping("/cars")
    public ResponseEntity<List<CarDTO>> getAllCars(){
        List<CarDTO> carDTOS = carService.findAll();
        if (carDTOS != null) {
            return new ResponseEntity<>(carDTOS, HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/car")
    public ResponseEntity<Void> addCar(@RequestBody CarDTO carDTO){
        this.carService.save(carDTO);
        return null;
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable Long id){
        CarDTO carDTO = carService.getCarById(id);
        if (carDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carDTO);
    }

    @PutMapping("/car/{id}")
    public ResponseEntity<CarDTO> updateCar(@PathVariable Long id, @RequestBody CarDTO car){
        CarDTO existingCarDTO = carService.getCarById(id);
        if (existingCarDTO == null) {
            return ResponseEntity.notFound().build();
        }
        existingCarDTO.setModel(car.getModel());
        existingCarDTO.setManufacturer(car.getManufacturer());
        existingCarDTO.setProductionYear(car.getProductionYear());
        CarDTO updatedCar = carService.updateCar(existingCarDTO);
        return ResponseEntity.ok(updatedCar);
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable Long id){
        CarDTO existingCar = carService.getCarById(id);
        if (existingCar == null) {
            return ResponseEntity.notFound().build();
        }
        carService.deleteCar(id);
        return ResponseEntity.ok().build();
    }
}
