package com.elasticexample.springboot_elastic_app.controller;

import com.elasticexample.springboot_elastic_app.model.CarModel;
import com.elasticexample.springboot_elastic_app.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PostMapping
    public void save(@RequestBody CarModel car){
        carRepository.save(car);
    }

    @GetMapping("/{id}")
    public CarModel findById(@PathVariable String id){
        return carRepository.findById(id).orElse(null);
    }

    @GetMapping("/{id}")
    public Iterable<CarModel> findAll(){
        return carRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
         carRepository.deleteById(id);
    }

    @PutMapping
    public void update(@RequestBody CarModel car){
        carRepository.save(car);
    }

    @GetMapping("/find")
    public List<CarModel> findByBrand(@PathVariable String brand){
        return carRepository.findAllByBrand(brand);
    }
}
