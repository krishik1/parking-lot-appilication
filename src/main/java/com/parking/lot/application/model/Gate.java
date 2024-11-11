package com.parking.lot.application.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public abstract class Gate {
    private String location;
    private Operator operator;
}
