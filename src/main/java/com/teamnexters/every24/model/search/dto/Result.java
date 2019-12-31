package com.teamnexters.every24.model.search.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {
    @JsonProperty("place_id")
    private String id;

    public String getId() {
        return id;
    }
}
