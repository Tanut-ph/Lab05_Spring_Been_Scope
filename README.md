# Lab05_Spring_Been_Scope

## โปรเจกต์นี้คืออะไร
โปรเจกต์นี้เป็น Spring Boot REST API สำหรับจัดการข้อมูลกาแฟ โดยใช้โครงสร้างแบบ MVC ง่าย ๆ เพื่อแสดงหลักการทำงานของ Controller, Service และ Model

## ฟีเจอร์หลัก
- ดูเมนูทั้งหมด
- ดูรเมนูตามรหัส
- เพิ่มเมนูใหม่
- อัปเดตข้อมูลเมนู
- ลบเมนู
- ค้นหาเมนูตามชื่อ

## โครงสร้างโปรเจกต์
- Controller: จัดการ Request และ Response
- Service: ประกอบธุรกิจ logic และจัดการข้อมูล
- Model: ตัวแทนข้อมูลกาแฟ

## วิธีรันโปรเจกต์
### 1. ตรวจสอบว่า Java ถูกติดตั้งแล้ว
โปรเจกต์นี้ต้องใช้ JDK ที่รองรับ Java 17 ขึ้นไป

### 2. รันด้วย Maven Wrapper
บน Windows:
```powershell
mvnw.cmd spring-boot:run
```

บน macOS / Linux:
```bash
./mvnw spring-boot:run
```

### 3. เปิดเบราว์เซอร์หรือใช้คำสั่ง curl
เมื่อโปรเจกต์เริ่มทำงานสำเร็จ จะรันที่พอร์ต 8080

## API ที่รองรับ
### ดึงรายการกาแฟทั้งหมด
```bash
curl http://localhost:8080/coffees
```

### ดึงกาแฟตาม ID
```bash
curl http://localhost:8080/coffees/1
```

### เพิ่มกาแฟใหม่
```bash
curl -X POST http://localhost:8080/coffees \
  -H "Content-Type: application/json" \
  -d '{"name":"Mocha","price":65.0}'
```

### อัปเดตกาแฟ
```bash
curl -X PUT http://localhost:8080/coffees/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"Americano","price":50.0}'
```

### ลบกาแฟ
```bash
curl -X DELETE http://localhost:8080/coffees/1
```

### ค้นหากาแฟตามชื่อ
```bash
curl "http://localhost:8080/coffees/search?name=lat"
```

## หมายเหตุ
ข้อมูลในโปรเจกต์นี้เก็บไว้ในหน่วยความจำ (in-memory) ชั่วคราว ไม่ได้เชื่อมกับฐานข้อมูลใด ๆ
