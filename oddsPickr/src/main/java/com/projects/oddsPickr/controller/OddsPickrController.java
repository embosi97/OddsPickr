package com.projects.oddsPickr.controller;

import com.projects.oddsPickr.enums.MarketsEnum;
import com.projects.oddsPickr.enums.SportEnum;
import com.projects.oddsPickr.model.TeamEntity;
import com.projects.oddsPickr.service.OddsPickrServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Objects;

@CrossOrigin("*")
@RestController()
@RequestMapping("/upcoming")
public class OddsPickrController {

    @Autowired
    public OddsPickrServiceImpl service;

    @GetMapping(value = {"/{region}/{sport}/odds/{markets}", "/{region}/{sport}/odds", "/{region}/{sport}/odds/"},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<TeamEntity> displayEventsBySport(@PathVariable("sport") String theSport,
                                                      @PathVariable("region") String theRegion,
                                                      @PathVariable(name = "markets", required = false) String markets) {

        Object marketsValue = MarketsEnum.fromValues(markets);

        return service.displayOdds(
                Objects.requireNonNull(SportEnum.fromValue(theSport)).getSport(),
                theRegion,
                Objects.isNull(marketsValue) ? "h2h" : marketsValue.toString()
        );

    }

    @GetMapping(value = {"/{region}/{sport}/events/{eventId}/odds/{markets}", "/{region}/{sport}/events/{eventId}/odds", "/{region}/{sport}/events/{eventId}/odds/"},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public TeamEntity findEventById(@PathVariable("sport") String theSport,
                                    @PathVariable("region") String theRegion,
                                    @PathVariable("eventId") String eventId,
                                    @PathVariable(name = "markets", required = false) String markets) {

        Object marketsValue = MarketsEnum.fromValues(markets);

        return service.getEventById(
                Objects.requireNonNull(SportEnum.fromValue(theSport)).getSport(),
                theRegion,
                eventId,
                Objects.isNull(marketsValue) ? "h2h" : marketsValue.toString()
        );

    }
}