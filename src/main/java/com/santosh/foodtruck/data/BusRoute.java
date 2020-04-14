package com.santosh.foodtruck.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BusRoute {
    
    @JsonProperty("Description")
    private String Description;
    
    @JsonProperty("ProviderID")
    private String ProviderID;
    
    @JsonProperty("Route")
    private String Route;
    
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }
    public String getProviderID() {
        return ProviderID;
    }
    public void setProviderID(String providerID) {
        ProviderID = providerID;
    }
    public String getRoute() {
        return Route;
    }
    public void setRoute(String route) {
        Route = route;
    }

    @Override
    public String toString() {
        return "BusRoute [Description=" + Description + ", ProviderID=" + ProviderID + ", Route=" + Route + "]";
    }
}