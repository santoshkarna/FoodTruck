package com.santosh.foodtruck.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stop {
    
    @JsonProperty("Text")
    private String stopDescription;
    
    @JsonProperty("Value")
    private String stopName;
    
    
    public String getStopDescription() {
        return stopDescription;
    }
    public void setStopDescription(String stopDescription) {
        this.stopDescription = stopDescription;
    }
    public String getStopName() {
        return stopName;
    }
    public void setStopName(String stopName) {
        this.stopName = stopName;
    }

    

}
