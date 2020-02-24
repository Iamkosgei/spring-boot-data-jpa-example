package me.kosgei.springJpa.service;

import me.kosgei.springJpa.model.Car;
import me.kosgei.springJpa.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepo carRepo;

    public List<Car> allCars(){
        List<Car> cars = new ArrayList<>();
         carRepo.findAll().forEach(cars :: add);
         return  cars;
    }

    public List<Car> getAllCarsBelongingToUser(int userId){
        return new ArrayList<>(carRepo.findCarByUserId(userId));
    }
    public void addCar(Car car){
        carRepo.save(car);

    }


}
