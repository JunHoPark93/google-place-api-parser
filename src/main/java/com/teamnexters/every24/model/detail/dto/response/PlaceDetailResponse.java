package com.teamnexters.every24.model.detail.dto.response;

import com.teamnexters.every24.model.detail.dto.Periods;

import java.util.List;

public class PlaceDetailResponse {
    private List<Periods> periods;
    private List<String> weekDay;

    private PlaceDetailResponse() {
    }

    public PlaceDetailResponse(final List<Periods> periods, final List<String> weekDay) {
        this.periods = periods;
        this.weekDay = weekDay;
    }

    public List<Periods> getPeriods() {
        return periods;
    }

    public List<String> getWeekDay() {
        return weekDay;
    }
}
