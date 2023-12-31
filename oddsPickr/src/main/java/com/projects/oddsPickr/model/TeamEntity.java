package com.projects.oddsPickr.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
@SuperBuilder
@JsonAutoDetect()
public class TeamEntity {

    private String eventId;

    private String sportName;

    private String homeTeam;

    private String awayTeam;

    private String eventTime;

    private Map<String, OddsObject> oddsMap;

    @Override
    public String toString() {

        return String.format("%s vs %s", this.awayTeam, this.homeTeam);
    }

}
