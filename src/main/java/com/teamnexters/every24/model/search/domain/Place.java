package com.teamnexters.every24.model.search.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placeId;

    public Place(final String placeId) {
        this.placeId = placeId;
    }

    public Long getId() {
        return id;
    }

    public String getPlaceId() {
        return placeId;
    }
}
