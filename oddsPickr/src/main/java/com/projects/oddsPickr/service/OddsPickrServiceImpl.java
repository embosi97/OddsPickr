package com.projects.oddsPickr.service;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.projects.oddsPickr.model.OddsObject;
import org.json.JSONException;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;
import com.projects.oddsPickr.model.TeamEntity;

import javax.money.Monetary;
import javax.money.UnknownCurrencyException;
import javax.money.convert.CurrencyConversionException;
import javax.money.convert.MonetaryConversions;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

@Slf4j
@Service
public class OddsPickrServiceImpl implements OddsPickrService {

    @Value("${api.key}")
    private String apiKey;

    @Value("${oddsApi.url}")
    private String oddsApiUrl;

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public ArrayList<TeamEntity> displayOdds(String sport, String region, String markets) {

        ArrayList<TeamEntity> entityArrayList = new ArrayList<>();

        try {

            final JsonNode response = Unirest
                    .get(String.valueOf(UriComponentsBuilder.fromUriString(oddsApiUrl)
                            .path("{sport}/odds/")
                            .queryParams(new LinkedMultiValueMap() {{
                                put("apiKey", Collections.singletonList(apiKey));
                                put("regions", Collections.singletonList(region));
                                put("markets", Collections.singletonList(markets));
                            }})
                            .build(sport, String.class)))
                    .asJson()
                    .getBody();

            IntStream.range(0, response.getArray().length())
                    .forEach(index -> {
                        try {
                            entityArrayList.add(
                                    TeamEntity
                                            .builder()
                                            .eventId(String.valueOf(response.getArray().getJSONObject(index).get("id")))
                                            .sportName(String.valueOf(response.getArray().getJSONObject(index).get("sport_title")))
                                            .homeTeam(String.valueOf(response.getArray().getJSONObject(index).get("home_team")))
                                            .awayTeam(String.valueOf(response.getArray().getJSONObject(index).get("away_team")))
                                            .eventTime(ZonedDateTime.parse(String.valueOf(response.getArray().getJSONObject(index)
                                                    .get("commence_time")), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX")).toString())
                                            .oddsMap(getAllOdds(((JSONArray) response.getArray().getJSONObject(index).get("bookmakers"))))
                                            .build()
                            );
                        } catch (JSONException e) {
                            log.info("Invalid JSON.");
                            throw new RuntimeException(e);
                        }
                    });

            return entityArrayList;

        } catch (UnirestException e) {
            log.info("Invalid URL.");
            throw new RuntimeException(e);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "rawtypes"})
    public TeamEntity getEventById(String sport, String region, String eventId, String markets) {

        try {

            final JsonNode response = Unirest
                    .get(String
                            .valueOf(UriComponentsBuilder.fromUriString(oddsApiUrl)
                            .path("{sport}/events/{eventId}/odds")
                            .queryParams(new LinkedMultiValueMap() {{
                                put("apiKey", Collections.singletonList(apiKey));
                                put("regions", Collections.singletonList(region));
                                put("markets", Collections.singletonList(markets));
                            }})
                            .build(sport, eventId, String.class)))
                    .asJson()
                    .getBody();

            return TeamEntity
                    .builder()
                    .eventId(String.valueOf(response.getObject().get("id")))
                    .sportName(String.valueOf(response.getObject().get("sport_title")))
                    .homeTeam(String.valueOf(response.getObject().get("home_team")))
                    .awayTeam(String.valueOf(response.getObject().get("away_team")))
                    .eventTime(ZonedDateTime.parse(String.valueOf(response.getObject()
                            .get("commence_time")), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssX")).toString())
                    .oddsMap(getAllOdds(((JSONArray) response.getObject().get("bookmakers"))))
                    .build();

        } catch (UnirestException e) {
            log.info("Invalid URL.");
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<String, OddsObject> getAllOdds(JSONArray jsonArray) {

        HashMap<String, OddsObject> oddsObjectHashMap = new HashMap<>();

        IntStream.range(0, jsonArray.length()
                )
                .forEach(index -> {
                            try {
                                oddsObjectHashMap
                                        .put(String.valueOf(jsonArray.getJSONObject(index).get("title")),
                                                OddsObject
                                                        .builder()
                                                        .homeOdds(String.valueOf(jsonArray.getJSONObject(index).getJSONArray("markets")
                                                                .getJSONObject(0).getJSONArray("outcomes").getJSONObject(0).get("price")))
                                                        .awayOdds(String.valueOf(jsonArray.getJSONObject(index).getJSONArray("markets")
                                                                .getJSONObject(0).getJSONArray("outcomes").getJSONObject(1).get("price")))
                                                        .build()
                                        );
                            } catch (JSONException e) {
                                log.info("Error occurred while retrieving odds for event.");
                                throw new RuntimeException();
                            }
                        }
                );

        return oddsObjectHashMap;
    }

    @Override
    public float convertPayoutCurrency(final float bet, final String odds, final String currentCurr, final String targetCurr) {

        try {

            return Monetary
                    .getDefaultAmountFactory()
                    .setCurrency(currentCurr)
                    .setNumber(bet * Float.parseFloat(odds))
                    .create()
                    .with(MonetaryConversions.getConversion(targetCurr))
                    .getNumber()
                    .floatValue();

        } catch (UnknownCurrencyException | CurrencyConversionException ex) {

            throw new RuntimeException();
        }
    }

    @Override
    public String payoutAsString(final float payout, final String targetCurr) {

        return Currency
                .getInstance(targetCurr)
                .getSymbol()
                .concat(String.valueOf(payout));
    }
}


