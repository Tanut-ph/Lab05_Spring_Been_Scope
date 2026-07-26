package com.example.miniproject.Service;
import java.util.ArrayList;
import java.util.List;

import com.example.miniproject.Model.Coffee;

public class CoffeeService {
private final List<Coffee> coffees = new ArrayList<>();

    public CoffeeService() {
        coffees.add(new Coffee(1, "Espresso", 50));
        coffees.add(new Coffee(2, "Latte", 65));
        coffees.add(new Coffee(3, "Cappuccino", 70));
    }

    public List<Coffee> getAll() {
        return coffees;
    }

    // ค้นหาตาม id
    public Coffee getById(int id) {
        for (Coffee coffee : coffees) {
            if (coffee.getId() == id) {
                return coffee;
            }
        }
        return null;
    }

    // เพิ่มข้อมูล
    public void addCoffee(Coffee coffee) {
        coffees.add(coffee);
    }

    // ลบข้อมูล
    public boolean deleteCoffee(int id) {
        return coffees.removeIf(c -> c.getId() == id);
    }

    // แก้ไขข้อมูล
    public boolean updateCoffee(int id, Coffee newCoffee) {
        for (int i = 0; i < coffees.size(); i++) {
            if (coffees.get(i).getId() == id) {
                coffees.set(i, newCoffee);
                return true;
            }
        }
        return false;
    }
}
