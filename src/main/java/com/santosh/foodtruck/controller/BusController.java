package com.santosh.foodtruck.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.santosh.foodtruck.data.Bus;
import com.santosh.foodtruck.data.BusRoute;
import com.santosh.foodtruck.data.Stop;
import com.santosh.foodtruck.data.Time;

@RestController
public class BusController {

    @RequestMapping(value = "/apiconsumption.html", method = RequestMethod.GET)
    public ModelAndView getBusForm() {
        ModelAndView model = new ModelAndView("search");
        return model;
    }

    @RequestMapping(value = "/nextBus.html", method = RequestMethod.POST)
    public ModelAndView submitBusForm(@ModelAttribute("busObj") Bus busObj) {

        /***
         * Call GetRoutes for getting all the routes and match it with the form input
         */

        RestTemplate restTemplate = new RestTemplate();
        BusRoute[] busRouteObj = restTemplate.getForObject("http://svc.metrotransit.org/NexTrip/Routes",
                BusRoute[].class);

        int objLength = busRouteObj.length;
        String routeDesciption = "";
        String routeID = "";
        for (int i = 0; i < objLength; i++) {
            if (busRouteObj[i].getDescription().equalsIgnoreCase(busObj.getBusRoute())) {
                routeDesciption = busRouteObj[i].getDescription();
                routeID = busRouteObj[i].getRoute();
            }
        }

        /**
         * Get the selected Direction
         */

        String direction = busObj.getDirection();

        /**
         * Pass the RouteID and the direction from the above 2 to GetStops to get Stop
         * value
         */
        final String uriStop = "http://svc.metrotransit.org/NexTrip/Stops/{ROUTE}/{DIRECTION}";
        Map<String, String> params = new HashMap<String, String>();
        params.put("ROUTE", routeID);
        params.put("DIRECTION", direction);

        Stop[] stopValue = restTemplate.getForObject(uriStop, Stop[].class, params);
        String stopDescription = "";
        String stopName = "";
        for (int i = 0; i < stopValue.length; i++) {
            if (stopValue[i].getStopDescription().equalsIgnoreCase(busObj.getBusStop())) {
                stopDescription = stopValue[i].getStopDescription();
                stopName = stopValue[i].getStopName();
            }
        }

        System.out.println("Selected Bus Route - " + routeDesciption);
        System.out.println("Corresponding Route ID - " + routeID);
        System.out.println("Selected Bus Stop - " + stopDescription);
        System.out.println("Corresponding Stop Name - " + stopName);
        System.out.println("Direction - " + direction);

        /**
         * Send RouteID, StopName and Direction to GetTimePointDepartures Return
         * DepartuteText and DepartureTime
         */
        final String uriTime = "http://svc.metrotransit.org/NexTrip/{ROUTE}/{DIRECTION}/{STOP}";

        Map<String, String> paramsTime = new HashMap<String, String>();
        paramsTime.put("ROUTE", routeID);
        paramsTime.put("DIRECTION", direction);
        paramsTime.put("STOP", stopName);

        Time[] timeValue = restTemplate.getForObject(uriTime, Time[].class, paramsTime);
        String departureText = timeValue[0].getDepartureText();

        System.out.println("Next bus is in - " + departureText);

        String directionName = "";
        if (direction.equals("1")) {
            directionName = "South";
        } else if (direction.equals("2")) {
            directionName = "East";
        } else if (direction.equals("3")) {
            directionName = "West";
        } else {
            directionName = "North";
        }

        ModelAndView model = new ModelAndView("searchSuccessful");
        model.addObject("direction", directionName);
        model.addObject("departureText", departureText);
        model.addObject("msg", "Information Retrieved");
        return model;
    }
}
