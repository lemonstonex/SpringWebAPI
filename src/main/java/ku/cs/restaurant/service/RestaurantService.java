package ku.cs.restaurant.service;

import ku.cs.restaurant.entity.Restaurant;
import ku.cs.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RestaurantService {
    @Autowired
    private RestaurantRepository repository;

    public List<Restaurant> getAll() {
        return repository.findAll();
    }


    public Restaurant create(Restaurant restaurant) {
        Restaurant record = repository.save(restaurant);
        return record;
    }

    // ค้นด้วย id
    public Restaurant getRestaurantById(UUID id) {
        return repository.findById(id).get();
    }

    // การ put ที่ update ได้
    public Restaurant update(Restaurant requestBody) {
        UUID id = requestBody.getId();
        Restaurant record = repository.findById(id).get();
        record.setName(requestBody.getName());
        record.setRating(requestBody.getRating());
        record.setLocation(requestBody.getLocation());


        record = repository.save(record);
        return record;
    }

    // delete ได้
    public Restaurant delete(UUID id) {
        Restaurant record = repository.findById(id).get();
        repository.deleteById(id);
        return record;
    }

    //ค้นหาด้วยชื่อ
    public Restaurant getRestaurantByName(String name) {
        return repository.findByName(name);
    }

    //ค้นหาด้วยสถานที่
    public List<Restaurant> getRestaurantByLocation(String location) {
        return repository.findByLocation(location);
    }


}


/**
 @Service เหมือน @Component ที่ให้สปริงสร้าง obj อัตโนมัติ
 @Autowired ทำ dependency injection ที่จะส่ง object ของ repository มา service
 *
 *
 *
 หน้าที่ controller : รับผิดชอบการ handle user request
 หน้าที่ service  : รับผิดชอบการประมวลผลและจัดการข้อมูล
 หน้าที่ repository  : รับผิดชอบการเชื่อมต่อฐานข้อมูล
 */