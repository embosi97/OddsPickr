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
import java.util.Optional;

@CrossOrigin("*")
@RestController()
@RequestMapping("/upcoming")
public class OddsPickrController {

    @Autowired
    public OddsPickrServiceImpl service;

    @GetMapping(value = {"/{region}/{sport}/odds/{markets}", "/{region}/{sport}/odds/**"},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<TeamEntity> displayEventsBySport(@PathVariable("sport") String theSport,
                                                      @PathVariable("region") String theRegion,
                                                      @PathVariable(name = "markets", required = false) Optional<String> markets) {

        return service
                .displayOdds(
                        Objects.requireNonNull(SportEnum.fromValue(theSport)).getSport(),
                        theRegion,
                        markets.isPresent() ? Objects.requireNonNull(MarketsEnum.fromValues(markets.get())).toString() : "h2h"
                );

    }

    @GetMapping(value = {"/{region}/{sport}/events/{eventId}/odds/{markets}", "/{region}/{sport}/events/{eventId}/odds/**"},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public TeamEntity findEventById(@PathVariable("sport") String theSport,
                                    @PathVariable("region") String theRegion,
                                    @PathVariable("eventId") String eventId,
                                    @PathVariable(name = "markets", required = false) Optional<String> markets) {

        return service
                .getEventById(
                        Objects.requireNonNull(SportEnum.fromValue(theSport)).getSport(),
                        theRegion,
                        eventId,
                        markets.isPresent() ? Objects.requireNonNull(MarketsEnum.fromValues(markets.get())).toString() : "h2h"
                );

    }
}