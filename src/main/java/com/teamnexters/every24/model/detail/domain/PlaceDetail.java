package com.teamnexters.every24.model.detail.domain;

import com.teamnexters.every24.model.detail.dto.Periods;
import com.teamnexters.every24.model.search.domain.Place;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.List;

public class PlaceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Place place;

    private List<Periods> periods;

    private List<String> weekDay;

    public PlaceDetail(final Place place, final List<Periods> periods, final List<String> weekDay) {
        this.place = place;
        this.periods = periods;
        this.weekDay = weekDay;
    }

    public Long getId() {
        return id;
    }

    public Place getPlace() {
        return place;
    }

    public List<Periods> getPeriods() {
        return periods;
    }

    public List<String> getWeekDay() {
        return weekDay;
    }
}
