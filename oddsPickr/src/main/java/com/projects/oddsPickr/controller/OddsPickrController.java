package com.projects.oddsPickr.controller;

import com.projects.oddsPickr.enums.MarketsEnum;
import com.projects.oddsPickr.enums.SportEnum;
import com.projects.oddsPickr.model.TeamEntity;
import com.projects.oddsPickr.service.OddsPickrServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Objects;

@CrossOrigin("*")
@RestController()
@RequestMapping("/upcoming")
public class OddsPickrController {

    @Autowired
    public OddsPickrServiceImpl service;

    @GetMapping(value = "/{region}/{sport}/odds/{markets}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<TeamEntity> displayEventsBySport(@PathVariable("sport") String theSport,
                                                      @PathVariable("region") String theRegion,
                                                      @PathVariable("markets") String markets) {

        return service.displayOdds(
                Objects.requireNonNull(SportEnum.fromValue(theSport)).getSport(),
                theRegion,
                Objects.requireNonNull(MarketsEnum.fromValues(markets)).toString()
        );

//        String payout = service.payoutAsString(service.convertPayoutCurrency(500, teamEntities.get(0).getOddsMap().get("FanDuel").getHomeOdds(), "USD", "GBP"), "GBP");

//        String payout = service.payoutAsString(service.convertPayoutCurrency(500, "2.6", "USD", "GBP"), "EUR");

//        System.out.println(payout);

    }

    @GetMapping(value = "/{region}/{sport}/events/{eventId}/odds/{markets}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public TeamEntity findEventById(@PathVariable("sport") String theSport,
                                    @PathVariable("region") String theRegion,
                                    @PathVariable("eventId") String eventId,
                                    @PathVariable("markets") String markets) {

        return service.getEventById(
                Objects.requireNonNull(SportEnum.fromValue(theSport)).getSport(),
                theRegion,
                eventId,
                Objects.requireNonNull(MarketsEnum.fromValues(markets)).toString()
        );

    }
}