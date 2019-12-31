package com.teamnexters.every24.model.search.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.teamnexters.every24.invoker.ApiInvoker;
import com.teamnexters.every24.model.detail.domain.PlaceDetail;
import com.teamnexters.every24.model.detail.dto.PlaceSearchDetailResult;
import com.teamnexters.every24.model.detail.dto.response.PlaceDetailResponse;
import com.teamnexters.every24.model.search.domain.Place;
import com.teamnexters.every24.model.search.dto.PlaceSearchResult;
import com.teamnexters.every24.support.GoogleSearchApiParser;
import org.springframework.stereotype.Service;

// TODO overall refac
@Service
public class PlaceService {
    private final ApiInvoker apiInvoker;

    public PlaceService(final ApiInvoker apiInvoker) {
        this.apiInvoker = apiInvoker;
    }

    public PlaceDetailResponse getHours(final String placeName) {
        // Search 도메인 저장
        String searchResultString = apiInvoker.getSearchResultString(placeName);
        PlaceSearchResult placeSearchResult = parsePlace(searchResultString);
        // TODO fields를 주지 않는다면 배열에 place_id 하나만 내려오는데 이렇게 할지?
        Place place = new Place(placeSearchResult.getResults().get(0).getId());

        // DetailSearch 도메인 저장
        String openingHoursString = apiInvoker.getOpeningHoursString(place.getPlaceId());
        PlaceSearchDetailResult placeSearchDetailResult = parsePlaceDetail(openingHoursString);
        PlaceDetail placeDetail = new PlaceDetail(place, placeSearchDetailResult.getResult().getOpeningHours().getPeriods(),
                placeSearchDetailResult.getResult().getOpeningHours().getWeekday());

        return toDto(placeDetail);
    }

    private PlaceDetailResponse toDto(final PlaceDetail placeDetail) {
        return new PlaceDetailResponse(placeDetail.getPeriods(), placeDetail.getWeekDay());
    }

    private PlaceSearchDetailResult parsePlaceDetail(final String searchDetailResultString) {
        try {
            return GoogleSearchApiParser.parseSearchDetailResult(searchDetailResultString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }

    private PlaceSearchResult parsePlace(final String searchResultString) {
        try {
            // TODO response status 예외처리
            return GoogleSearchApiParser.parseSearchResult(searchResultString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        throw new RuntimeException();
    }
}
