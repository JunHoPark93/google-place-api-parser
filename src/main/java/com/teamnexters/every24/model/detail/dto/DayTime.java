package com.teamnexters.every24.model.detail.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DayTime {
    @JsonProperty("day")
    private int day;

    @JsonProperty("time")
    private String time;

    public int getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }
}
