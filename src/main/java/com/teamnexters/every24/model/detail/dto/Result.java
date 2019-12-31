package com.teamnexters.every24.model.detail.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
    @JsonProperty("opening_hours")
    private OpeningHours openingHours;

    public OpeningHours getOpeningHours() {
        return openingHours;
    }
}
