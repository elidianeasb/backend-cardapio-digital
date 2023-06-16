package com.example.cardapio.controller;

import com.example.cardapio.entity.Food;
import com.example.cardapio.repository.FoodRepository;
import com.example.cardapio.dto.FoodRequest;
import com.example.cardapio.dto.FoodResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repositoy;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequest data){
        Food foodData = new Food(data);
        repositoy.save(foodData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponse> getAll(){
        List<FoodResponse> foodList = repositoy.findAll().stream().map(FoodResponse::new).toList();
        return foodList;
    }
}
