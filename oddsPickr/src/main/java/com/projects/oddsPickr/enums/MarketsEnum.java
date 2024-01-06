package com.projects.oddsPickr.enums;

import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
public enum MarketsEnum {

    h2h("h2h"),

    totals("totals"),

    spreads("spreads"),

    outrights("outrights", "futures");

    private final List<String> markets;

    MarketsEnum(String... markets) {
        this.markets = List.of(markets);
    }

    public static MarketsEnum fromValues(String key) {

        if (Objects.isNull(key)) return null;

        for (MarketsEnum me : MarketsEnum.values()) {
            if (me.getMarkets().contains(key)) {
                return me;
            }
        }
        return null;
    }
}
