package com.teamnexters.every24.model.detail.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceSearchDetailResult {
    @JsonProperty("result")
    private Result result;

    @JsonProperty("status")
    private String status;

    public Result getResult() {
        return result;
    }

    public String getStatus() {
        return status;
    }
}
