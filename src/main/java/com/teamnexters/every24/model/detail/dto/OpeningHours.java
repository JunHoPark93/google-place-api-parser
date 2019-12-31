package com.teamnexters.every24.model.detail.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OpeningHours {
    @JsonProperty("open_now")
    private boolean isOpen;

    @JsonProperty("periods")
    private List<Periods> periods;

    @JsonProperty("weekday_text")
    private List<String> weekday;

    public boolean isOpen() {
        return isOpen;
    }

    public List<Periods> getPeriods() {
        return periods;
    }

    public List<String> getWeekday() {
        return weekday;
    }
}
