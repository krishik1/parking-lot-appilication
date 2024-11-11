package com.parking.lot.application.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
@Getter
@Setter
@SuperBuilder
public class Payment extends BaseModel {
    private String ticketId;
    private double amount;
    private String referenceId;
    private PaymentStatus status;
    private LocalDateTime timeStamp;
    private PaymentMode mode;
}
