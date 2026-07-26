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
        // วนลูปหาว่าตอนนี้ ID สูงสุดคือเลขอะไร
        for (Coffee c : coffees) {
            if (c.getId() > maxId) {
                maxId = c.getId();
            }
        }
        
        // เอา ID สูงสุดมาบวก 1 แล้วจับยัดใส่ข้อมูลใหม่
        coffee.setId(maxId + 1); 
        coffees.add(coffee);
        return coffee; 
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
    public List<Coffee> searchByName(String name) {
        List<Coffee> result = new ArrayList<>();
        for (Coffee coffee : coffees) {
            // แปลงเป็นตัวพิมพ์เล็กทั้งคู่ก่อนเทียบ เพื่อให้ค้นหาได้ง่ายขึ้น
            if (coffee.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(coffee);
            }
        }
        return result;
    }
}