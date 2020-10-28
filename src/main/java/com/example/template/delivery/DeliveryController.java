package com.example.template.delivery;

import com.example.template.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeliveryController {

    @Autowired
    DeliveryService deliveryService;

    @GetMapping("/delivery/{deliveryId}")
    Delivery selectDelivery(@PathVariable(value = "deliveryId") Long deliveryId) {
        return  this.deliveryService.getDeliveryById(deliveryId);
    }

    @PostMapping("/cancel/{deliveryId}")
    Delivery canceledDelivery(@PathVariable(value = "deliveryId") Long deliveryId) {
        Delivery delivery = deliveryService.getDeliveryById(deliveryId);


        return  this.deliveryService.getDeliveryById(deliveryId);
    }

    @PostMapping("/delivery")
    Delivery insertDelivery(@RequestBody String data) {

        return this.deliveryService.save(data);
    }

}
