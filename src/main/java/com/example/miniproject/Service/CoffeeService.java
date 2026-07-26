package com.example.miniproject.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.miniproject.Model.Coffee;

@Service
public class CoffeeService {
    private final List<Coffee> coffees = new ArrayList<>();

    public CoffeeService() {
        coffees.add(new Coffee(1, "Espresso", 45.5));
        coffees.add(new Coffee(2, "Latte", 55.0));
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

    // เพิ่มข้อมูล (สร้าง ID อัตโนมัติต่อจากอันล่าสุด)
    public Coffee addCoffee(Coffee coffee) {
        int maxId = 0;
        for (Coffee c : coffees) {
            if (c.getId() > maxId) {
                maxId = c.getId();
            }
        }
        
        coffee.setId(maxId + 1); // กำหนด ID ใหม่
        coffees.add(coffee);
        return coffee; // คืนค่า Object ที่เพิ่งสร้าง
    }

    // ลบข้อมูล
    public boolean deleteCoffee(int id) {
        return coffees.removeIf(c -> c.getId() == id);
    }

    // แก้ไขข้อมูล
    public Coffee updateCoffee(int id, Coffee newCoffee) {
        for (int i = 0; i < coffees.size(); i++) {
            if (coffees.get(i).getId() == id) {
                newCoffee.setId(id); // กำหนด ID ให้ตรงกับ ID ที่ต้องการแก้ไข
                coffees.set(i, newCoffee); // อัปเดตข้อมูลใน List
                return newCoffee; // คืนค่าข้อมูลใหม่กลับไป
            }
        }
        return null; // คืนค่า null ถ้าไม่พบ ID ที่ต้องการแก้
    }
}