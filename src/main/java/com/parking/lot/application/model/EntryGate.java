package com.parking.lot.application.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class EntryGate extends Gate{
    private DisplayBoard displayBoard;
}
