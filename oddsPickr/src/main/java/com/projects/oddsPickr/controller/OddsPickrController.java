package com.projects.oddsPickr.controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.projects.oddsPickr.enums.SportEnum;
import com.projects.oddsPickr.model.TeamEntity;
import com.projects.oddsPickr.service.OddsPickrServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Objects;

@RestController()
@RequestMapping("/upcoming")
public class OddsPickrController {

    @Autowired
    public OddsPickrServiceImpl service;

    @CrossOrigin("*")
    @GetMapping(value = "/{region}/{sport}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<TeamEntity> displayEventsBySport(@PathVariable("sport") String theSport, @PathVariable("region") String theRegion) {

//        JsonElement gson = new Gson().toJsonTree(service.displayOdds(Objects.requireNonNull(SportEnum.fromValue(theSport)).getSport(), theRegion).get(0));

        return service.displayOdds(Objects.requireNonNull(SportEnum.fromValue(theSport)).getSport(), theRegion);

//        String payout = service.payoutAsString(service.convertPayoutCurrency(500, teamEntities.get(0).getOddsMap().get("FanDuel").getHomeOdds(), "USD", "GBP"), "GBP");

//        String payout = service.payoutAsString(service.convertPayoutCurrency(500, "2.6", "USD", "GBP"), "EUR");

//        System.out.println(payout);

    }
}