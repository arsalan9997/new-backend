package com.airline.baggage.model;

import jakarta.persistence.*;

@Entity
@Table(name = "baggage")
public class Baggage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String passengerName;

    private String flightNumber;

    @Column(unique = true, nullable = false)
    private String baggageTag;

    private Double weight;

    private String status;

    public Baggage() {
    }

    public Baggage(
            String passengerName,
            String flightNumber,
            String baggageTag,
            Double weight,
            String status) {

        this.passengerName = passengerName;
        this.flightNumber = flightNumber;
        this.baggageTag = baggageTag;
        this.weight = weight;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getBaggageTag() {
        return baggageTag;
    }

    public void setBaggageTag(String baggageTag) {
        this.baggageTag = baggageTag;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
