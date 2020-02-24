package me.kosgei.springJpa.repository;

import me.kosgei.springJpa.model.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo extends CrudRepository<Car,Integer> {
    public List<Car> findCarByUserId(int id);
}
