package com.projects.oddsPickr.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class OddsObject {

    private String homeOdds;

    private String awayOdds;

}
