package com.teamnexters.every24.web;

import com.teamnexters.every24.model.detail.dto.response.PlaceDetailResponse;
import com.teamnexters.every24.model.search.service.PlaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaceApiController {
    private final PlaceService placeService;

    public PlaceApiController(final PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/api/v1/hours")
    public ResponseEntity<PlaceDetailResponse> hours(@RequestParam String placeName) {
        PlaceDetailResponse hours = placeService.getHours(placeName);
        return ResponseEntity.ok(hours);
    }
}
