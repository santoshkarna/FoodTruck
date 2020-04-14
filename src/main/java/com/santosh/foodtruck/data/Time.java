package com.santosh.foodtruck.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Time {

    @JsonProperty("Actual")
    private boolean actual;

    @JsonProperty("BlockNumber")
    private int blockNumber;

    @JsonProperty("DepartureText")
    private String departureText;

    @JsonProperty("DepartureTime")
    private String departureTime;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Gate")
    private String gate;

    @JsonProperty("Route")
    private String route;

    @JsonProperty("RouteDirection")
    private String routeDirection;

    @JsonProperty("Terminal")
    private String terminal;

    @JsonProperty("VehicleHeading")
    private int vehicleHeading;

    @JsonProperty("VehicleLatitude")
    private int vehicleLatitude;

    @JsonProperty("VehicleLongitude")
    private int vehicleLongitude;

    public boolean isActual() {
        return actual;
    }

    public void setActual(boolean actual) {
        this.actual = actual;
    }

    public int getBlockNumber() {
        return blockNumber;
    }

    public void setBlockNumber(int blockNumber) {
        this.blockNumber = blockNumber;
    }

    public String getDepartureText() {
        return departureText;
    }

    public void setDepartureText(String departureText) {
        this.departureText = departureText;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getRouteDirection() {
        return routeDirection;
    }

    public void setRouteDirection(String routeDirection) {
        this.routeDirection = routeDirection;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public int getVehicleHeading() {
        return vehicleHeading;
    }

    public void setVehicleHeading(int vehicleHeading) {
        this.vehicleHeading = vehicleHeading;
    }

    public int getVehicleLatitude() {
        return vehicleLatitude;
    }

    public void setVehicleLatitude(int vehicleLatitude) {
        this.vehicleLatitude = vehicleLatitude;
    }

    public int getVehicleLongitude() {
        return vehicleLongitude;
    }

    public void setVehicleLongitude(int vehicleLongitude) {
        this.vehicleLongitude = vehicleLongitude;
    }

}
