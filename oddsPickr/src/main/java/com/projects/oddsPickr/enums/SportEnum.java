package com.projects.oddsPickr.enums;

import lombok.Getter;

@Getter
public enum SportEnum {

    nfl("americanfootball_nfl"),
    epl("soccer_epl"),
    laliga("soccer_spain_la_liga"),
    seriea("soccer_italy_serie_a"),
    mls("soccer_usa_mls"),
    boxing("boxing_boxing"),
    mlb("baseball_mlb"),
    mma("mma_mixed_martial_arts"),
    cfl("americanfootball_cfl"),
    wnba("basketball_wnba"),
    nhl("icehockey_nhl"),
    nba("basketball_nba"),
    nrl("rugbyleague_nrl");

    private final String sport;

    SportEnum(String sport) {
        this.sport = sport;
    }

    public static SportEnum fromValue(String key) {

        for (SportEnum se : SportEnum.values()) {
            if (se.name().equals(key)) {
                return se;
            }
        }
        return null;
    }

}