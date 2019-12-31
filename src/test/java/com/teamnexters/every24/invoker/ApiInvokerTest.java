package com.teamnexters.every24.invoker;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamnexters.every24.model.detail.dto.OpeningHours;
import com.teamnexters.every24.model.detail.dto.PlaceSearchDetailResult;
import com.teamnexters.every24.model.search.dto.PlaceSearchResult;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class ApiInvokerTest {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String NAVER_D_CAMP_PLACE_ID = "ChIJQbP7LQmkfDURHe96IAvBcHY";

    @Mock
    private ApiInvoker apiInvoker;

    @Test
    void 장소_id_찾기() throws IOException, ParseException {
        // given
        JSONObject jsonObject = getJsonObject("testdata/SearchResult.json");
        given(apiInvoker.getSearchResultString("DCAMP")).willReturn(jsonObject.toJSONString());

        // when
        String jsonString = apiInvoker.getSearchResultString("DCAMP");
        PlaceSearchResult placeSearchResult = MAPPER.readValue(jsonString, PlaceSearchResult.class);

        // then
        assertThat(placeSearchResult.getStatus()).isEqualTo("OK");
        assertThat(placeSearchResult.getResults().get(0).getId()).isEqualTo(NAVER_D_CAMP_PLACE_ID);
    }

    @Test
    void 장소_운영시간_찾기() throws IOException, ParseException {
        // given
        JSONObject jsonObject = getJsonObject("testdata/DetailSearchResult.json");
        given(apiInvoker.getOpeningHoursString(NAVER_D_CAMP_PLACE_ID)).willReturn(jsonObject.toJSONString());

        // when
        String jsonString = apiInvoker.getOpeningHoursString(NAVER_D_CAMP_PLACE_ID);
        PlaceSearchDetailResult placeSearchDetailResult = MAPPER.readValue(jsonString, PlaceSearchDetailResult.class);
        OpeningHours openingHours = placeSearchDetailResult.getResult().getOpeningHours();

        // then
        assertThat(openingHours.getPeriods().size()).isEqualTo(6);
        assertThat(openingHours.getWeekday().size()).isEqualTo(7);
    }

    private JSONObject getJsonObject(final String path) throws IOException, ParseException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(path)).getFile());
        JSONParser parser = new JSONParser();
        FileReader fileReader = new FileReader(file);
        return (JSONObject) parser.parse(fileReader);
    }
}