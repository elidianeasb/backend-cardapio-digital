package com.example.cardapio.controller;

import com.example.cardapio.entity.Food;
import com.example.cardapio.repository.FoodRepository;
import com.example.cardapio.dto.FoodRequest;
import com.example.cardapio.dto.FoodResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveFood(@RequestBody FoodRequest data){
        Food foodData = new Food(data);
        repository.save(foodData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<FoodResponse> getAll(){
        List<FoodResponse>foodList = repository.findAll().stream().map(FoodResponse::new).toList();
        return foodList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{foodId}")
    ResponseEntity<?> deleteFoodById(
            @PathVariable(value = "foodId") Long foodId
    ){
        repository.deleteById(foodId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
