package com.example.miniproject.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.miniproject.Model.Coffee;
import com.example.miniproject.Service.CoffeeService;

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
    @GetMapping("/coffees/{id}")
    public Coffee getCoffeeById(@PathVariable int id) {
        return coffeeService.getById(id);
    }
    @PostMapping("/coffees")
    public Coffee addCoffee(@RequestBody Coffee coffee) {
        return coffeeService.addCoffee(coffee);
    }
    @PutMapping("/coffees/{id}")
    public Coffee updateCoffee(@PathVariable int id,
                           @RequestBody Coffee coffee) {

        return coffeeService.updateCoffee(id, coffee);
    }
    @DeleteMapping("/coffees/{id}")
    public boolean deleteCoffee(@PathVariable int id) {
        return coffeeService.deleteCoffee(id);
    }
    @GetMapping("/coffees/search")
    public List<Coffee> searchCoffeesByName(@RequestParam("name") String name) {
        return coffeeService.searchByName(name);
    }
}
