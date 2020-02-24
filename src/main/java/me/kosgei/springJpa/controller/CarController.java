package me.kosgei.springJpa.controller;

import me.kosgei.springJpa.model.Car;
import me.kosgei.springJpa.service.CarService;
import me.kosgei.springJpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @Autowired
    private UserService userService;


    @GetMapping("/cars")
    public List<Car> getAllCars(){
        return carService.allCars();
    }

    @PostMapping("/car/{id}/new")
    public void addCar(@RequestBody Car car, @PathVariable int id){
        car.setUser(userService.findUserById(id));
        carService.addCar(car);
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<List<Car>> getCars(@PathVariable int id){
        return ResponseEntity.ok().body(carService.getAllCarsBelongingToUser(id));

    }

}
