package com.teamnexters.every24.invoker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.StandardCharsets;

@Component
public class ApiInvoker {
    private static final String END_POINT = "https://maps.googleapis.com/maps/api/place/findplacefromtext/json";
    private static final String DETAIL_END_POINT = "https://maps.googleapis.com/maps/api/place/details/json";

    private final RestTemplate restTemplate;

    @Value("${google.key}")
    private String key;

    public ApiInvoker(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getSearchResultString(final String placeName) {
        return restTemplate.getForObject(createUrl(placeName), String.class);
    }

    private String createUrl(final String placeName) {
        return UriComponentsBuilder.fromHttpUrl(END_POINT)
                .queryParam("input", placeName)
                .queryParam("inputtype", "textquery")
                .queryParam("key", key)
                .build()
                .encode(StandardCharsets.UTF_8)
                .toString();
    }

    public String getOpeningHoursString(String placeId) {
        return restTemplate.getForObject(createDetailUrl(placeId), String.class);
    }

    private String createDetailUrl(final String placeId) {
        return UriComponentsBuilder.fromHttpUrl(DETAIL_END_POINT)
                .queryParam("place_id", placeId)
                .queryParam("fields", "opening_hours")
                .queryParam("key", key)
                .toUriString();
    }
}
