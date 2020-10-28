package com.example.template.rental;

import com.example.template.Application;
import com.example.template.book.BookService;
import com.example.template.delivery.Delivery;
import com.example.template.delivery.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
public class RentalController {

    @Autowired
    RentalService rentalService;

    @Autowired
    DeliveryService deliveryService;

    @GetMapping("/rental/{rentalId}")
    Rental selectRental(@PathVariable(value = "rentalId") Long rentalId) {
        return  this.rentalService.getRentalById(rentalId);
    }

    @PostMapping("/rental")
    Rental insertRental(@RequestBody String data) {

        return this.rentalService.save(data);
    }


    @Autowired
    Environment env;
    /**
     * env 혹은 설정 값을 가져오는 테스트 코드
     */
    @GetMapping("/env")
    String getEnvSample() {
        System.out.println(" @Value = " + "skykyw");

        return "skykyw";
    }
}
