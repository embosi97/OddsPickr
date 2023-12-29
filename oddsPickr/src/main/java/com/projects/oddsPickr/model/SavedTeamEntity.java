package com.projects.oddsPickr.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
public class SavedTeamEntity extends TeamEntity {

    private float amountBet;

    private String currency;

}
