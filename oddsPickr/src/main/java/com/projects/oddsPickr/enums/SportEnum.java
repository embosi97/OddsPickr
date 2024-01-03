package com.projects.oddsPickr.enums;

import lombok.Getter;

@Getter
public enum SportEnum {

    /*
    -----------------------------------
    American Football
    */
    nfl("americanfootball_nfl"),
    ncaaf("americanfootball_ncaaf"),
    /*
    -----------------------------------
    Association Football
    */
    ucl("soccer_uefa_champs_league"),
    europaleague("soccer_uefa_europa_league"),
    epl("soccer_epl"),
    laliga("soccer_spain_la_liga"),
    seriea("soccer_italy_serie_a"),
    ligue1("soccer_france_ligue_one"),
    bundesliga("soccer_germany_bundesliga"),
    eredivisie("soccer_netherlands_eredivisie"),
    premeiraliga("soccer_portugal_primeira_liga"),
    mls("soccer_usa_mls"),
    ligamx("soccer_mexico_ligamx"),
    /*
    -----------------------------------
    Combat Sports
    */
    boxing("boxing_boxing"),
    mma("mma_mixed_martial_arts"),
    /*
    -----------------------------------
    American Baseball
    */
    mlb("baseball_mlb"),
    /*
    -----------------------------------
    Canadian Football
    */
    cfl("americanfootball_cfl"),
    /*
    -----------------------------------
    Ice Hockey
    */
    nhl("icehockey_nhl"),
    nhlstanleycup("icehockey_nhl_championship_winner"),
    hockeyallsvenskan("icehockey_sweden_allsvenskan"),
    /*
    -----------------------------------
    Basketball
    */
    nba("basketball_nba"),
    fibaeuroleague("basketball_euroleague"),
    ncaab("basketball_ncaab"),
    wnba("basketball_wnba"),
    /*
    -----------------------------------
    Rugby
    */
    nrl("rugbyleague_nrl"),
    /*
    -----------------------------------
    Golf
    */
    pga("golf_pga_championship_winner"),
    usopen("golf_us_open_winner"),
    /*
    -----------------------------------
    Cricket
    */
    bigbashleague("cricket_big_bash");

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