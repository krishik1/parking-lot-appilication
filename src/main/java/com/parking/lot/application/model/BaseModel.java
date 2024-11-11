package com.parking.lot.application.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
@Getter
@Setter
@SuperBuilder
public abstract class BaseModel {
    private Long id;
    private Date createdAt;
    private Date uodatedAt;
}
