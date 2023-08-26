package ku.cs.restaurant.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Restaurant {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private double rating;
    private String location;

}

/**
 @Entity    บอกว่าเป็นตารางข้อมูล -- ให้ map ตารางมาเป็น object ของคลาสนี้
 @Id        บอกว่าเป็น Primary Key
 @GeneratedValue ให้ generate โดยอัตโนมัติ -- ใช้ UUID เพื่อความปลอดภัย
 @Data ช    ช่วยลดการเขียน getters, setters
  **/