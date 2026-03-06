package com.tutorial.user_service.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tutorial.user_service.entity.User;
import com.tutorial.user_service.model.Bike;
import com.tutorial.user_service.model.Car;
import com.tutorial.user_service.repository.I_UserRepository;

@Service
public class UserService {

    @Autowired
    I_UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;


    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User  getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }

    public User save(User user){
        User userNew= userRepository.save(user);
        return userNew;
    }

    public List<Car> getCars(int userId){
       Car[] carsArray = restTemplate.getForObject("http://localhost:8002/car/byuser/" + userId,Car[].class);

        List<Car> cars = Arrays.asList(carsArray);

        return cars;
    }

    public List<Bike> getBikes(int userId){
       Bike[] bikeArray = restTemplate.getForObject("http://localhost:8003/bike/byuser/" + userId,Bike[].class);

        List<Bike> bikes = Arrays.asList(bikeArray);

        return bikes;
    }

}
