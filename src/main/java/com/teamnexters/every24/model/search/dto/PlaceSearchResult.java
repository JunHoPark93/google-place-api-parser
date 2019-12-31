package com.teamnexters.every24.model.search.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PlaceSearchResult {
    @JsonProperty("candidates")
    private List<Result> results;

    @JsonProperty("status")
    private String status;

    public List<Result> getResults() {
        return results;
    }

    public String getStatus() {
        return status;
    }
}
