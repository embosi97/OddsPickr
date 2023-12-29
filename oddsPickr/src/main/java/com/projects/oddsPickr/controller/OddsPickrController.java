package com.projects.oddsPickr.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.util.ArrayList;
import java.util.Objects;

@Controller
@RequestMapping("/upcoming")
public class OddsPickrController {

    @Autowired
    public OddsPickrServiceImpl service;

    @CrossOrigin("*")
    @GetMapping(value = "/{region}/{sport}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<TeamEntity> displayEventsBySport(@PathVariable("sport") String theSport, @PathVariable("region") String theRegion) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
//
//
//        objectMapper.writeValueAsString(entities.get(0));

        return service.displayOdds(Objects.requireNonNull(SportEnum.fromValue(theSport)).getSport(), theRegion);

//        String payout = service.payoutAsString(service.convertPayoutCurrency(500, teamEntities.get(0).getOddsMap().get("FanDuel").getHomeOdds(), "USD", "GBP"), "GBP");

//        String payout = service.payoutAsString(service.convertPayoutCurrency(500, "2.6", "USD", "GBP"), "EUR");

//        System.out.println(payout);

    }
}