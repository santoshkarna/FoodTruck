package com.santosh.foodtruck.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.santosh.foodtruck.data.FoodTruck;
import com.santosh.foodtruck.data.FoodTruckConstants;

@RunWith(SpringRunner.class)
public class FoodTruckControllerTest {

    
    @Test
    public void testData() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<FoodTruck>> response = restTemplate.exchange(FoodTruckConstants.SF_FOOD_TRUCK_URl,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<FoodTruck>>() {
                });
        assertThat(response.getStatusCode(), is(equalTo(HttpStatus.OK)));
    }
}
