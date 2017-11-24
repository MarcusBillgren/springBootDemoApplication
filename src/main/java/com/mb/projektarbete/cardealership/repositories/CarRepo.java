package com.mb.projektarbete.cardealership.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mb.projektarbete.cardealership.cars.Car;

public interface CarRepo extends CrudRepository<Car,Long>{

}
