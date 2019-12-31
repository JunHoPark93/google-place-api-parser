package com.teamnexters.every24.support;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamnexters.every24.model.detail.dto.PlaceSearchDetailResult;
import com.teamnexters.every24.model.search.dto.PlaceSearchResult;

public class GoogleSearchApiParser {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private GoogleSearchApiParser() {
    }

    public static PlaceSearchResult parseSearchResult(final String input) throws JsonProcessingException {
        return MAPPER.readValue(input, PlaceSearchResult.class);
    }

    public static PlaceSearchDetailResult parseSearchDetailResult(final String input) throws JsonProcessingException {
        return MAPPER.readValue(input, PlaceSearchDetailResult.class);
    }
}
