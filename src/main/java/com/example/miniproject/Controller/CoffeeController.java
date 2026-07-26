package com.example.miniproject.Controller;

import com.example.miniproject.Model.Coffee;
import com.example.miniproject.Service.CoffeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CoffeeController {
    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }
    @GetMapping("/coffees")
    public List<Coffee> getAllCoffees() {
        return coffeeService.getAll();
    }
}
