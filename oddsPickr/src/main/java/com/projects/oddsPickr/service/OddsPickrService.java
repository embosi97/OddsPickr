package com.projects.oddsPickr.service;

import com.projects.oddsPickr.model.OddsObject;
import com.projects.oddsPickr.model.TeamEntity;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public interface OddsPickrService {
    ArrayList<TeamEntity> displayOdds(final String sport, final String region, final String markets);

    TeamEntity getEventById(final String sport, final String region, final String eventId, final String markets);

    Map<String, OddsObject> getAllOdds(final JSONArray jsonArray);

    float convertPayoutCurrency(final float bet, final String odds, final String currentCurr, final String targetCurr);

    String payoutAsString(float payout, final String targetCurr);

}
