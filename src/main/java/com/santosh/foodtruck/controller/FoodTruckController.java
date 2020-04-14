package com.santosh.foodtruck.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.santosh.foodtruck.data.FoodTruck;
import com.santosh.foodtruck.data.FoodTruckConstants;

@RestController
public class FoodTruckController {

    @GetMapping("/food_data")
    public ResponseEntity<List<FoodTruck>> getData() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<FoodTruck> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(FoodTruckConstants.SF_FOOD_TRUCK_URl, HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<FoodTruck>>() {
                });
    }
}
