package com.teamnexters.every24.model.detail.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Periods {
    @JsonProperty("close")
    private DayTime closeDayTime;

    @JsonProperty("open")
    private DayTime openDayTime;

    public DayTime getCloseDayTime() {
        return closeDayTime;
    }

    public DayTime getOpenDayTime() {
        return openDayTime;
    }
}
